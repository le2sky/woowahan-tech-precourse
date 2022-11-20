package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.commom.constant.GameState;
import bridge.model.BridgeHistory;
import bridge.model.BridgeManager;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.HashMap;

public class BridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private BridgeHistory bridgeHistory;
    private BridgeManager bridgeManager;

    public BridgeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void playGreeting() {
        outputView.printGreeting();
    }

    public void setupGame(BridgeNumberGenerator bridgeNumberGenerator) {
        int size = inputView.readBridgeSize();
        bridgeHistory = new BridgeHistory(new HashMap<>(), size);
        bridgeManager = new BridgeManager(bridgeNumberGenerator);
        bridgeManager.setBridgeWithSize(size);
    }

    public GameState getNowGameProgress() {
        return bridgeHistory.getProgress();
    }

    public void moveOneStep() {
        String userCommand = inputView.readMoving();
        boolean isMovable = bridgeManager.isMovable(userCommand, bridgeHistory.getNowStage());
        bridgeHistory.updateGameState(userCommand, isMovable);
        outputView.printMap(bridgeHistory);
    }

    public void figureOutToRestartGame() {

    }

    public void showResult() {

    }
}
