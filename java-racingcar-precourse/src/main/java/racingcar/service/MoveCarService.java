package racingcar.service;

import racingcar.domain.RacingCarGame;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.Round;
import racingcar.dto.RacingResultDto;
import racingcar.dto.WinnerResultDto;
import racingcar.repository.RacingCarGameRepository;
import racingcar.repository.RandomNumberGeneratorRepository;
import racingcar.repository.RoundRepository;

public class MoveCarService {
    public boolean isGameEnd() {
        RacingCarGame racingCarGame = RacingCarGameRepository.find();
        return racingCarGame.isGameEnd();
    }

    public WinnerResultDto winner() {
        RacingCarGame racingCarGame = RacingCarGameRepository.find();
        return racingCarGame.winner();
    }

    public RacingResultDto move() {
        RacingCarGame racingCarGame = RacingCarGameRepository.find();
        Round round = RoundRepository.find();
        RandomNumberGenerator randomNumberGenerator = RandomNumberGeneratorRepository.find();

        return racingCarGame.move(round, randomNumberGenerator);
    }
}
