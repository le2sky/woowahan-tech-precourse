package racingcar.service;

import racingcar.domain.Round;
import racingcar.repository.RoundRepository;

public class SetupRoundService {

    public void setup(int round) {
        RoundRepository.save(new Round(round));
    }
}
