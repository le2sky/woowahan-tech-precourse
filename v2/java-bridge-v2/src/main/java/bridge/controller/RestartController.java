package bridge.controller;

import bridge.common.constant.RestartableCommand;
import bridge.service.RestartService;
import bridge.view.InputView;

public class RestartController {

    private final RestartService restartService;
    private final InputView inputView;
    private final ShowResultController showResultController;


    public RestartController() {
        this.restartService = new RestartService();
        this.showResultController = new ShowResultController();
        this.inputView = new InputView();
    }

    public void restart() {
        String command = inputView.readGameCommand();
        restartService.restart(RestartableCommand.from(command));
        boolean restarted = restartService.isRestarted();

        if(!restarted)
            showResultController.showResult();
    }
}
