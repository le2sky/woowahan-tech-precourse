package racingcar.common.seeder;

import racingcar.domain.RacingCarGame;
import racingcar.repository.RacingCarGameRepository;

public class DataSourceSeeder {

    public void seed() {
        RacingCarGameRepository.save(new RacingCarGame());
    }
}
