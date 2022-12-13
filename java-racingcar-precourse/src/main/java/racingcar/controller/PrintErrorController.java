package racingcar.controller;

import racingcar.view.OutputView;

public class PrintErrorController {
    private final OutputView outputView;

    public PrintErrorController() {
        this.outputView = new OutputView();
    }

    public void printError(Exception err) {
        outputView.printError(err);
    }

}
