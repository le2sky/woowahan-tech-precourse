package bridge.domain;

import bridge.common.constant.BridgeGameProgress;

public class BridgeGameState {

    private BridgeGameProgress progress;
    private int retry;
    private int nowFloor;

    public BridgeGameState() {
        this.progress = BridgeGameProgress.PLAY;
        this.retry = 1;
        this.nowFloor = 0;
    }

    public void changeProgress(BridgeGameProgress bridgeGameProgress) {
        this.progress = bridgeGameProgress;
    }

    public void cross() {
        nowFloor++;
    }

    public void retry() {
        nowFloor = 0;
        retry++;
    }

    public BridgeGameProgress getProgress() {
        return progress;
    }

    public int getRetry() {
        return retry;
    }

    public int getNowFloor() {
        return nowFloor;
    }
}
