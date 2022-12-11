package lotto.service;

import lotto.domain.LottoMachine;
import lotto.domain.RandomGenerator;
import lotto.domain.User;
import lotto.repository.LottoMachineRepository;
import lotto.repository.UserRepository;

public class SeedDataSourceService {

    public void seeding() {
        seedUser();
        seedLottoMachine();
    }

    private void seedLottoMachine() {
        LottoMachineRepository.save(new LottoMachine(new RandomGenerator()));
    }

    private void seedUser() {
        UserRepository.save(new User());
    }
}
