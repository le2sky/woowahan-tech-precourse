package bridge.controller;

import bridge.common.constant.BridgeDirection;
import bridge.domain.BridgeGameHistory;
import bridge.dto.GameHistoryDto;
import bridge.service.MoveBridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class MoveBridgeController {

    private final InputView inputView;
    private final OutputView outputView;
    private final MoveBridgeService moveBridgeService;

    public MoveBridgeController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.moveBridgeService = new MoveBridgeService();
    }

    public void move() {
        String direction = inputView.readMoving();
        moveBridgeService.move(BridgeDirection.from(direction));
        GameHistoryDto history = moveBridgeService.getHistory();
        outputView.printMap(history);
    }
}
