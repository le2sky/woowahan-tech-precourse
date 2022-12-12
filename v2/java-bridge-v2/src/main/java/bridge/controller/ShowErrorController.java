package bridge.controller;

import bridge.view.OutputView;

public class ShowErrorController {

    private final OutputView outputView;

    public ShowErrorController() {
        this.outputView = new OutputView();
    }

    public void printError(Exception err) {
        outputView.printError(err);
    }
}
