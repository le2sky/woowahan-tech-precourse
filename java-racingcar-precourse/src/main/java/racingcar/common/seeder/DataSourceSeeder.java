package racingcar.common.seeder;

import racingcar.domain.CarGenerator;
import racingcar.domain.RacingCarGame;
import racingcar.repository.CarGeneratorRepository;
import racingcar.repository.RacingCarGameRepository;

public class DataSourceSeeder {

    public void seed() {
        RacingCarGameRepository.save(new RacingCarGame());
        CarGeneratorRepository.save(new CarGenerator());
    }
}
