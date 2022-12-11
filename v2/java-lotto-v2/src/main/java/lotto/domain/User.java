package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<LottoHistory> histories = new ArrayList<>();
    private Money investment;

    public void chargeMoney(Money investment) {
        this.investment = investment;
    }

    public Revenue calculateRevenue() {
        return null;
    }

    public void draw(RaffleMachine raffleMachine) {

    }

    public void buy(LottoMachine lottoMachine) {
        List<Lotto> lottos = lottoMachine.produce(investment);
        initializeHistories(lottos);
    }

    private void initializeHistories(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            LottoHistory history = new LottoHistory(lotto);
            histories.add(history);
        }
    }

    public List<Lotto> showLottos() {
        List<Lotto> lottos = new ArrayList<>();
        for (LottoHistory history : histories) {
            Lotto lotto = history.showLotto();
            lottos.add(lotto);
        }

        return lottos;
    }
}
