package racingcar.service;

import racingcar.domain.CarGenerator;
import racingcar.domain.RacingCarGame;
import racingcar.repository.CarGeneratorRepository;
import racingcar.repository.RacingCarGameRepository;

import java.util.List;

public class ArrangeCarService {

    public void arrange(List<String> names) {
        RacingCarGame racingCarGame = RacingCarGameRepository.find();
        CarGenerator carGenerator = CarGeneratorRepository.find();
        racingCarGame.arrange(carGenerator, names);
    }
}
