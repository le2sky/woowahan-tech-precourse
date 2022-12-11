package lotto.repository;

import lotto.domain.LottoMachine;
import lotto.domain.RaffleMachine;

public class RaffleMachineRepository {
    private static RaffleMachine raffleMachine;

    public static void save(RaffleMachine raffleMachine) {
        RaffleMachineRepository.raffleMachine = raffleMachine;
    }

    public static RaffleMachine find() {
        return raffleMachine;
    }
}
