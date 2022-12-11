package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoHistory;
import lotto.domain.LottoPlace;
import lotto.domain.Revenue;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private final HashMap<LottoPlace, Integer> board = new HashMap<>();
    private final String PRODUCE_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void printProducedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRODUCE_LOTTO_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printHistories(List<LottoHistory> lottoHistories) {
        System.out.println("당첨 통계");
        System.out.println("---");

        setBoard(lottoHistories);
        printResult();
    }

    private void printResult() {
        LottoPlace[] places = LottoPlace.values();
        for (LottoPlace place : places) {
            if (place.equals(LottoPlace.YET) || place.equals(LottoPlace.LOST))
                continue;
            System.out.println(place.getCondition() + " - " + board.getOrDefault(place, 0) + "개");
        }
    }

    private void setBoard(List<LottoHistory> lottoHistories) {
        for (LottoHistory lottoHistory : lottoHistories) {
            LottoPlace lottoPlace = lottoHistory.showPlace();
            int count = board.getOrDefault(lottoPlace, 0);
            board.put(lottoPlace, count + 1);
        }
    }

    public void printRevenue(Revenue revenue) {
        System.out.println("총 수익률은 " + revenue.toString() + "입니다.");
    }
}
