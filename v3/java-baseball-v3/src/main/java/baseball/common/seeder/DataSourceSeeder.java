package baseball.common.seeder;

import baseball.domain.BaseballGame;
import baseball.domain.GameState;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Referee;
import baseball.repository.BaseballGameRepository;
import baseball.repository.RandomNumberGeneratorRepository;
import baseball.repository.RefereeRepository;

public class DataSourceSeeder {

    public void seed() {
        BaseballGameRepository.save(new BaseballGame(GameState.PLAY));
        RefereeRepository.save(new Referee());
        RandomNumberGeneratorRepository.save(new RandomNumberGenerator());
    }
}
