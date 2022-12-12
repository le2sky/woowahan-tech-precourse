package bridge.controller;

import bridge.service.RoundCheckService;

public class ControllerResolver {
    private final MakeBridgeController makeBridgeController;
    private final RestartController restartController;
    private final ShowResultController showResultController;
    private final MoveBridgeController moveBridgeController;
    private final RoundCheckService roundCheckService;
    private boolean isGameRunning;

    public ControllerResolver() {
        this.makeBridgeController = new MakeBridgeController();
        this.restartController = new RestartController();
        this.showResultController = new ShowResultController();
        this.moveBridgeController = new MoveBridgeController();
        this.roundCheckService = new RoundCheckService();
        this.isGameRunning = true;
    }


    public void run() {
        try {
            process();
        } catch (Exception e) {
        }
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
        makeBridgeController.make();
    }

    private void processPlay() {
        if (roundCheckService.checkPlay())
            moveBridgeController.move();
    }

    private void processFail() {
        if (roundCheckService.checkFail()) {
            isGameRunning = false;
            restartController.restart();
        }

        if (roundCheckService.checkPlay())
            isGameRunning = true;
    }

    private void processSuccess() {
        if (roundCheckService.checkSuccess()) {
            isGameRunning = false;
            showResultController.showResult();
        }
    }
}
