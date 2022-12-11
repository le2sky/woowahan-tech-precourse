package lotto.domain;

public class LottoHistory {
    private final Lotto lotto;
    private LottoPlace lottoPlace;

    public LottoHistory(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto showLotto() {
        return lotto;
    }
}
