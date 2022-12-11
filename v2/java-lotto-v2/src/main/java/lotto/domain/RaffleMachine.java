package lotto.domain;

import java.util.List;

public class RaffleMachine {

    private static final String NUMBER_CONTAIN_BONUS = "보너스 숫자는 정답에 포함되는 값이 들어갈 수 없습니다.";
    private static final String BONUS_OUT_OF_RANGE = "보너스 숫자는 1부터 45 사이의 숫자만 입력할 수 있습니다.";
    private int bonus;
    private List<Integer> answer;

    public void decideAnswer(List<Integer> answer, int bonus) {
        validateBonus(answer, bonus);
        validateAnswerNumbers(answer);

        this.answer = answer;
        this.bonus = bonus;
    }

    private void validateBonus(List<Integer> answer, int bonus) {
        if (answer.contains(bonus))
            throw new IllegalArgumentException(NUMBER_CONTAIN_BONUS);

        if (bonus < 1 || bonus > 45)
            throw new IllegalArgumentException(BONUS_OUT_OF_RANGE);

    }

    private void validateAnswerNumbers(List<Integer> answer) {
        new Lotto(answer);
    }

    public LottoPlace draw(Lotto lotto) {
        int luckNumberHitCount = getLuckNumberHitCount(lotto);
        boolean bonusHit = isBonusHitting(lotto);

        if (luckNumberHitCount == 6)
            return LottoPlace.FIRST;

        if (luckNumberHitCount == 5 && bonusHit)
            return LottoPlace.SECOND;

        if (luckNumberHitCount == 5)
            return LottoPlace.THIRD;

        if (luckNumberHitCount == 4)
            return LottoPlace.FOURTH;

        if (luckNumberHitCount == 3)
            return LottoPlace.FIFTH;

        return LottoPlace.LOST;
    }

    private int getLuckNumberHitCount(Lotto lotto) {
        int hit = 0;
        for (Integer luckyNumber : answer)
            if (lotto.contain(luckyNumber))
                hit++;

        return hit;
    }

    private boolean isBonusHitting(Lotto lotto) {
        return lotto.contain(bonus);
    }
}



