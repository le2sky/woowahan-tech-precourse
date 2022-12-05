package baseball;

import baseball.controlelr.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
         new BaseballGame(new BaseballGameController(new BaseballGameReferee(3))).run();
    }
}
