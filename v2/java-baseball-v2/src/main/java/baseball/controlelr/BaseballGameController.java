package baseball.controlelr;

import baseball.common.GameCommand;
import baseball.domain.BaseballGameAnswer;
import baseball.domain.BaseballGameAnswerGenerator;
import baseball.domain.BaseballGameRecord;
import baseball.domain.BaseballGameReferee;
import baseball.ui.InputView;
import baseball.ui.OutputView;

public class BaseballGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BaseballGameRecord baseballGameRecord = new BaseballGameRecord();
    private final BaseballGameReferee baseballGameReferee;
    private final BaseballGameAnswerGenerator baseballGameAnswerGenerator;

    public BaseballGameController(BaseballGameAnswerGenerator baseballGameAnswerGenerator) {
        this.baseballGameAnswerGenerator = baseballGameAnswerGenerator;
        BaseballGameAnswer answer = baseballGameAnswerGenerator.generateRandomAnswer();
        this.baseballGameReferee = new BaseballGameReferee(answer);
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
        BaseballGameAnswer userAnswer = baseballGameAnswerGenerator.generateAnswerFromInput(userGuessing);
        int strikeCount = baseballGameReferee.getStrikeCount(userAnswer);
        int ballCount = baseballGameReferee.getBallCount(userAnswer);
        if (isCorrect(strikeCount))
            baseballGameRecord.changeGameState();
    }

    private boolean isCorrect(int strikeCount) {
        return strikeCount == baseballGameReferee.getCorrectCount();
    }
}
