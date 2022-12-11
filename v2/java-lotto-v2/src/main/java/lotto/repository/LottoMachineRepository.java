package lotto.repository;

import lotto.domain.LottoMachine;

public class LottoMachineRepository {

    private static LottoMachine lottoMachine;

    public static void save(LottoMachine lottoMachine) {
        LottoMachineRepository.lottoMachine = lottoMachine;
    }

    public static LottoMachine find() {
        return lottoMachine;
    }
}
