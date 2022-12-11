package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.RaffleMachine;
import lotto.domain.RandomGenerator;
import lotto.domain.User;
import lotto.repository.LottoMachineRepository;
import lotto.repository.RaffleMachineRepository;
import lotto.repository.UserRepository;

public class SeedDataSourceService {

    public void seeding() {
        seedUser();
        seedLottoMachine();
        seedRaffleMachine();
    }

    private void seedLottoMachine() {
        LottoMachineRepository.save(new LottoMachine(new RandomGenerator()));
    }

    private void seedUser() {
        UserRepository.save(new User());
    }

    private void seedRaffleMachine() {
        RaffleMachineRepository.save(new RaffleMachine());
    }
}
