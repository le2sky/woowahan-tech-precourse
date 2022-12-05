package baseball;

import baseball.controlelr.BaseballGameController;

public class BaseballGame {

    private final BaseballGameController baseballGameController;

    public BaseballGame(BaseballGameController baseballGameController) {
        this.baseballGameController = baseballGameController;
        baseballGameController.initializeGame();
    }

    public void run() {
        processGamePlay();
        processGameEnd();
    }

    private void processGamePlay() {
        while (requestGameState()) {
            baseballGameController.playOneRound();
        }
    }

    private void processGameEnd() {
        requestPrintGameResult();
        if (requestRestartGame()) {
            run();
        }
    }

    private void requestPrintGameResult() {
        baseballGameController.showGameResult();
    }

    private boolean requestRestartGame() {
        return baseballGameController.isRestartable();
    }

    private boolean requestGameState() {
        return baseballGameController.isGameEnd();
    }
}
