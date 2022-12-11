package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private final String PRODUCE_LOTTO_MESSAGE = "개를 구매했습니다.";

    public void printProducedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + PRODUCE_LOTTO_MESSAGE);
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
