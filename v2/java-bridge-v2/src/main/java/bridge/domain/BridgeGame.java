package bridge.domain;

import bridge.common.constant.BridgeDirection;
import bridge.common.constant.BridgeGameProgress;
import bridge.dto.GameResultDto;

public class BridgeGame {

    private final BridgeGameState state;
    private final Bridge bridge;

    public BridgeGame(Bridge bridge) {
        this.bridge = bridge;
        this.state = new BridgeGameState();
    }

    public void move(BridgeDirection direction, BridgeGameHistory history) {
        int nowFloor = state.getNowFloor();
        boolean movable = bridge.isMovable(nowFloor, direction);
        changeGameStateWithCondition(nowFloor, movable);
        write(movable, direction, history);
    }

    public void write(boolean movable, BridgeDirection direction, BridgeGameHistory history) {
        if (movable)
            history.writeSuccess(direction);

        if (!movable)
            history.writeFail(direction);
    }

    public void retry(BridgeGameHistory history) {
        state.changeProgress(BridgeGameProgress.PLAY);
        state.retry();
        history.reset();
    }

    public boolean isSuccess() {
        return state.getProgress().equals(BridgeGameProgress.SUCCESS);
    }

    public boolean isFail() {
        return state.getProgress().equals(BridgeGameProgress.FAIL);
    }

    public boolean isPlay() {
        return state.getProgress().equals(BridgeGameProgress.PLAY);
    }

    public GameResultDto result() {
        return new GameResultDto(state.getRetry(), state.getProgress());
    }


    private void changeGameStateWithCondition(int nowFloor, boolean movable) {
        changeGameStateIfFail(movable);
        changeGameStateIfSuccess(movable, nowFloor);
    }

    private void changeGameStateIfSuccess(boolean movable, int nowFloor) {
        if (movable && bridge.isPassed(nowFloor))
            state.changeProgress(BridgeGameProgress.SUCCESS);

        if (movable)
            state.cross();
    }

    private void changeGameStateIfFail(boolean movable) {
        if (!movable)
            state.changeProgress(BridgeGameProgress.FAIL);
    }
}
