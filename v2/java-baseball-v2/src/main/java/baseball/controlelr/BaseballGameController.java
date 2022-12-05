package baseball.controlelr;

import baseball.BaseballGameRecord;
import baseball.BaseballGameReferee;
import baseball.common.GameCommand;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BaseballGameReferee baseballGameReferee;
    private final BaseballGameRecord baseballGameRecord;

    public BaseballGameController(BaseballGameReferee baseballGameReferee) {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.baseballGameRecord = new BaseballGameRecord();
        this.baseballGameReferee = baseballGameReferee;
    }

    public void initializeGame() {
        outputView.printGreet();
    }

    public boolean isGameEnd() {
        return baseballGameRecord.isGameEnd();
    }

    public boolean isRestartable() throws IllegalArgumentException {
        int restartCommand = Integer.parseInt(inputView.readRestartCommand());
        GameCommand.validateWrongCommand(restartCommand);
        return GameCommand.isRestartCommand(restartCommand);
    }

    public void showGameResult() {
        outputView.printResult(baseballGameReferee.getCorrectCount());
    }

    public void playOneRound() {
        String userGuessing = inputView.readUserGuessing();
        int strikeCount = baseballGameReferee.getStrikeCount(userGuessing);
        int ballCount = baseballGameReferee.getBallCount(userGuessing);
        if (isCorrect(strikeCount))
            baseballGameRecord.changeGameState();
    }

    private boolean isCorrect(int strikeCount) {
        return strikeCount == baseballGameReferee.getCorrectCount();
    }

}
