package racingcar.common.seeder;

import racingcar.domain.CarGenerator;
import racingcar.domain.RacingCarGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.repository.CarGeneratorRepository;
import racingcar.repository.RacingCarGameRepository;
import racingcar.repository.RandomNumberGeneratorRepository;

public class DataSourceSeeder {

    public void seed() {
        RacingCarGameRepository.save(new RacingCarGame());
        CarGeneratorRepository.save(new CarGenerator());
        RandomNumberGeneratorRepository.save(new RandomNumberGenerator());
    }
}
