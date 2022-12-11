package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final String CANT_BUY_MESSAGE = "로또 한장도 구매 못하는 투자금입니다.";
    private final int unitPrice = 1000;
    private final RandomGenerator randomGenerator;

    public LottoMachine(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public List<Lotto> produce(Money investment) {
        validateInvestment(investment);

        return createLotto(calculatePieces(investment));
    }

    private List<Lotto> createLotto(long pieces) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < pieces; i++) {
            Lotto lotto = create();
            lottos.add(lotto);
        }

        return lottos;
    }

    private long calculatePieces(Money investment) {
        long pieces = investment.getAmount() / unitPrice;
        return pieces;
    }

    private Lotto create() {
        List<Integer> randoms = randomGenerator.generate();
        return new Lotto(randoms);
    }

    private void validateInvestment(Money investment) {
        if (unitPrice > investment.getAmount())
            throw new IllegalArgumentException(CANT_BUY_MESSAGE);
    }
}
