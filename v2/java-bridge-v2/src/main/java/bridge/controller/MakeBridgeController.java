package bridge.controller;

import bridge.service.MakeBridgeService;
import bridge.view.InputView;

public class MakeBridgeController {

    private final InputView inputView;
    private final MakeBridgeService makeBridgeService;

    public MakeBridgeController() {
        this.inputView = new InputView();
        this.makeBridgeService = new MakeBridgeService();
    }

    public void make() {
        int size = Integer.parseInt(inputView.readBridgeSize());
        makeBridgeService.make(size);
    }
}
