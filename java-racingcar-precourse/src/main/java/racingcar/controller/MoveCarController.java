package racingcar.controller;

import racingcar.dto.RacingResultDto;
import racingcar.dto.WinnerResultDto;
import racingcar.service.MoveCarService;
import racingcar.view.OutputView;

public class MoveCarController {
    private final OutputView outputView;
    private final MoveCarService moveCarService;

    public MoveCarController() {
        this.outputView = new OutputView();
        this.moveCarService = new MoveCarService();
    }

    public boolean isGameEnd() {
        return moveCarService.isGameEnd();
    }

    public void move() {
        RacingResultDto moveResult = moveCarService.move();
        outputView.printRacingResult(moveResult);
    }

    public void winner() {
        WinnerResultDto winner =  moveCarService.winner();
        outputView.printWinner(winner);
    }

    public void showResultMessage() {
        outputView.printResultMessage();
    }

}
