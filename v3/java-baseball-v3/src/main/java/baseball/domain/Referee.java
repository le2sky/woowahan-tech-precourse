package baseball.domain;

import baseball.dto.BaseballGameResultDto;

public class Referee {

    private BaseballNumber answer;

    public void decideAnswer(BaseballNumber answer) {
        this.answer = answer;
    }

    public BaseballGameResultDto judge(BaseballNumber baseballNumber) {
        return null;
    }
}
