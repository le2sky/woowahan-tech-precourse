package baseball.ui;

public class OutputView {

    public static final String GREET_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String RESULT_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NOTHING = "낫싱";
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼 ";

    public void printGreet() {
        System.out.println(GREET_MESSAGE);
    }

    public void printResult(int correctCount) {
        System.out.println(correctCount + RESULT_MESSAGE);
    }

    public void printCorrectCount(int strikeCount, int ballCount) {
        String message = getMessage(strikeCount, ballCount);
        System.out.println(message);
    }

    private String getMessage(int strikeCount, int ballCount) {
        return getNothingMessage(strikeCount, ballCount) +
                getBallMessage(ballCount) +
                getStrikeMessage(strikeCount);
    }

    private String getStrikeMessage(int strikeCount) {
        if (strikeCount != 0)
            return strikeCount + STRIKE;
        return "";
    }

    private String getBallMessage(int ballCount) {
        if (ballCount != 0)
            return ballCount + BALL;
        return "";
    }

    private String getNothingMessage(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0)
            return NOTHING;
        return "";
    }
}
