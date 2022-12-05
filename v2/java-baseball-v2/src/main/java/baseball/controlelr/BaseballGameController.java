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
    private final BaseballGameAnswerGenerator baseballGameAnswerGenerator;

    private BaseballGameReferee baseballGameReferee;

    public BaseballGameController(BaseballGameAnswerGenerator baseballGameAnswerGenerator) {
        this.baseballGameAnswerGenerator = baseballGameAnswerGenerator;
    }

    public void initializeGame() {
        BaseballGameAnswer answer = baseballGameAnswerGenerator.generateRandomAnswer();
        baseballGameReferee = new BaseballGameReferee(answer);
    }

    public void greeting() {
        outputView.printGreet();
    }

    public boolean isGameEnd() {
        return baseballGameRecord.isGameEnd();
    }

    public boolean isRestartable() throws IllegalArgumentException {
        int restartCommand = Integer.parseInt(inputView.readRestartCommand());
        GameCommand.validateWrongCommand(restartCommand);
        boolean returning = GameCommand.isRestartCommand(restartCommand);
        if (returning)
            changeRecordGameState();

        return returning;
    }

    public void showGameResult() {
        outputView.printResult(baseballGameReferee.getCorrectCount());
    }

    public void playOneRound() {
        String userGuessing = inputView.readUserGuessing();
        BaseballGameAnswer userAnswer = getGameAnswer(userGuessing);
        int strikeCount = baseballGameReferee.getStrikeCount(userAnswer);
        int ballCount = baseballGameReferee.getBallCount(userAnswer) - strikeCount;

        correctHandler(strikeCount);
        outputView.printCorrectCount(strikeCount, ballCount);
    }

    private BaseballGameAnswer getGameAnswer(String userGuessing) {
        return baseballGameAnswerGenerator.generateAnswerFromInput(userGuessing);
    }

    private void correctHandler(int strikeCount) {
        if (isCorrectAll(strikeCount))
            changeRecordGameState();
    }

    private void changeRecordGameState() {
        baseballGameRecord.changeGameState();
    }

    private boolean isCorrectAll(int strikeCount) {
        return strikeCount == baseballGameReferee.getCorrectCount();
    }
}
