package bridge.controller;

import bridge.service.RoundCheckService;

public class ControllerResolver {
    private final MakeBridgeController makeBridgeController;
    private final RestartController restartController;
    private final ShowResultController showResultController;
    private final ShowErrorController showErrorController;
    private final MoveBridgeController moveBridgeController;
    private final RoundCheckService roundCheckService;
    private boolean isGameRunning;
    private boolean initialized;

    public ControllerResolver() {
        this.makeBridgeController = new MakeBridgeController();
        this.restartController = new RestartController();
        this.showResultController = new ShowResultController();
        this.showErrorController = new ShowErrorController();
        this.moveBridgeController = new MoveBridgeController();
        this.roundCheckService = new RoundCheckService();
        this.isGameRunning = true;
        this.initialized = false;
    }

    public void run() {
        try {
            process();
        } catch (Exception err) {
            handleError(err);
        }
    }

    private void handleError(Exception err) {
        showErrorController.printError(err);
    }

    private void process() {
        processSetting();
        while (isGameRunning) {
            processPlay();
            processFail();
            processSuccess();
        }
    }

    private void processSetting() {
        if (!initialized) {
            makeBridgeController.make();
            initialized = true;
        }
    }

    private void processPlay() {
        if (roundCheckService.checkPlay())
            moveBridgeController.move();
    }

    private void processFail() {
        if (roundCheckService.checkFail()) {
            restartController.restart();
            isGameRunning = false;
        }

        if (roundCheckService.checkPlay())
            isGameRunning = true;
    }

    private void processSuccess() {
        if (roundCheckService.checkSuccess()) {
            showResultController.showResult();
            isGameRunning = false;
        }
    }
}
