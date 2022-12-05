package baseball.domain;

public class BaseballGameReferee {

    private final BaseballGameAnswer answer;

    public BaseballGameReferee(BaseballGameAnswer answer) {
        this.answer = answer;
    }

    public int getStrikeCount(BaseballGameAnswer userGuessing) {
        int strikeCount = 0;
        for (int location = 0; location < answer.getAnswerLength(); location++)
            if (isStrike(userGuessing, location))
                strikeCount++;

        return strikeCount;
    }

    public int getBallCount(BaseballGameAnswer userGuessing) {
        int ballCount = 0;
        for(int location = 0; location < answer.getAnswerLength(); location++)
            if (isBall(userGuessing, location))
                ballCount++;

        return ballCount;
    }

    private boolean isStrike(BaseballGameAnswer userGuessing, int location) {
        return answer.isNumberAt(userGuessing.getNumberAt(location), location);
    }

    private boolean isBall(BaseballGameAnswer userGuessing, int location) {
        return answer.hasNumber(userGuessing.getNumberAt(location));
    }

    public int getCorrectCount() {
        return answer.getAnswerLength();
    }
}
