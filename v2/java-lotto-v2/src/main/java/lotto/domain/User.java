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
        long sum = 0;
        for (LottoHistory history : histories) {
            LottoPlace lottoPlace = history.showPlace();
            sum += lottoPlace.getPrize();
        }

        return new Revenue((double) sum / investment.getAmount() * 100);
    }

    public void draw(RaffleMachine raffleMachine) {
        int size = histories.size();
        for (LottoHistory history : histories) {
            Lotto lotto = history.showLotto();
            LottoPlace result = raffleMachine.draw(lotto);
            history.writeResult(result);
        }
    }

    public void buy(LottoMachine lottoMachine) {
        List<Lotto> lottos = lottoMachine.produce(investment);
        initializeHistories(lottos);
    }

    public List<LottoHistory> getHistories() {
        return histories;
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
