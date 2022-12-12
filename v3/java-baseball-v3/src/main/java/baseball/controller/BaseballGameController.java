package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }
}
