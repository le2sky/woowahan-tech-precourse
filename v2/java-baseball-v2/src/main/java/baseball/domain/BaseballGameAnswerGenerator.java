package baseball.domain;

public interface BaseballGameAnswerGenerator {

    public BaseballGameAnswer generateRandomAnswer();

    public BaseballGameAnswer generateAnswerFromInput(String input);
}
