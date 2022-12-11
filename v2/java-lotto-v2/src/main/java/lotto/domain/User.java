package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final List<LottoHistory> histories = new ArrayList<>();
    private final Money investment;


    public User(Money investment) {
        this.investment = investment;
    }

    public Revenue calculateRevenue() {
        return null;
    }

    public void buy(LottoMachine lottoMachine) {

    }

    public void draw(RaffleMachine raffleMachine) {

    }
}
