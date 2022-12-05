package baseball;

public class BaseballGameReferee {

    private final int answer;

    public BaseballGameReferee(int answer) {
        this.answer = answer;
    }

    public int getStrikeCount(String userGuessing) {
        return 0;
    }

    public int getBallCount(String userGuessing) {
        return 0;
    }

    public int getCorrectCount() {
        return Integer.toString(answer).length();
    }
}
