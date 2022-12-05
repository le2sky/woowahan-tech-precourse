package baseball;

import baseball.controlelr.BaseballGameController;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballGameAnswerGeneratorImpl;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new BaseballGame(new BaseballGameController(new BaseballGameAnswerGeneratorImpl())).run();
    }
}
