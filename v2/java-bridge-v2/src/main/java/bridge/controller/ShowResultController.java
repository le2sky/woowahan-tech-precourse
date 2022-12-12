package bridge.controller;

import bridge.dto.GameResultDto;
import bridge.service.ShowResultService;
import bridge.view.OutputView;

public class ShowResultController {

    private final ShowResultService showResultService;
    private final OutputView outputView;

    public ShowResultController() {
        this.showResultService = new ShowResultService();
        this.outputView = new OutputView();
    }

    public void showResult() {
        GameResultDto result = showResultService.getResult();
        outputView.printResult(result);
    }
}
