package baseball.domain;

public class BaseballGameReferee {

    private final BaseballGameAnswer answer;

    public BaseballGameReferee(BaseballGameAnswer answer) {
        this.answer = answer;
    }

    public int getStrikeCount(BaseballGameAnswer userGuessing) {
        return 0;
    }

    public int getBallCount(BaseballGameAnswer userGuessing) {
        return 0;
    }

    public int getCorrectCount() {
        return answer.getAnswerLength();
    }
}
