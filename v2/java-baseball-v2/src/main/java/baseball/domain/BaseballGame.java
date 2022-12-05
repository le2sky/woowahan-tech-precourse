package baseball.domain;

import baseball.controlelr.BaseballGameController;

public class BaseballGame {

    private final BaseballGameController baseballGameController;

    public BaseballGame(BaseballGameController baseballGameController) {
        this.baseballGameController = baseballGameController;
    }

    public void run() {
        greeting();
        repeatableProcess();
    }


    private void repeatableProcess() {
        processPlay();
        processGameEnd();
    }

    private void processPlay() {
        requestInitialization();
        while(!requestGameIsEnd())
            requestPlayOneRound();
    }

    private void processGameEnd() {
        requestPrintGameResult();
        if (requestRestartGame()) {
            repeatableProcess();
        }
    }

    private void requestInitialization() {
        baseballGameController.initializeGame();
    }

    private boolean requestGameIsEnd() {
        return baseballGameController.isGameEnd();
    }

    private void requestPlayOneRound() {
        baseballGameController.playOneRound();
    }

    private void requestPrintGameResult() {
        baseballGameController.showGameResult();
    }

    private boolean requestRestartGame() {
        return baseballGameController.isRestartable();
    }

    private void greeting() {
        baseballGameController.greeting();
    }
}
