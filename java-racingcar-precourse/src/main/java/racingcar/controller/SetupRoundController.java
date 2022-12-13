package racingcar.controller;

import racingcar.service.SetupRoundService;
import racingcar.view.InputView;

public class SetupRoundController {
    private final SetupRoundService setupRoundService;
    private final InputView inputView;

    public SetupRoundController() {
        this.setupRoundService = new SetupRoundService();
        this.inputView = new InputView();
    }

    public void setUp() {
        String round = inputView.readRound();
        setupRoundService.setup(Integer.parseInt(round));
    }
}
