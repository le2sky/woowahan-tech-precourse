package lotto.domain;

public class LottoHistory {

    private final Lotto lotto;
    private LottoPlace lottoPlace;

    public LottoHistory(Lotto lotto) {
        this.lotto = lotto;
        this.lottoPlace = LottoPlace.YET;
    }

    public void writeResult(LottoPlace lottoPlace) {
        this.lottoPlace = lottoPlace;
    }

    public Lotto showLotto() {
        return lotto;
    }
}
