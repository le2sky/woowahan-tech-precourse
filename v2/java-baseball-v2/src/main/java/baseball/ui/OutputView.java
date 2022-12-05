package baseball.ui;

public class OutputView {

    public static final String GREET_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String RESULT_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void printGreet() {
        System.out.println(GREET_MESSAGE);
    }

    public void printResult(int correctCount) {
        System.out.println(correctCount + RESULT_MESSAGE);
    }
}
