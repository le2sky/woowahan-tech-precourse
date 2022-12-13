package racingcar.repository;

import racingcar.domain.RacingCarGame;

public class RacingCarGameRepository {

    private static RacingCarGame racingCarGame;

    public static RacingCarGame find() {
        return racingCarGame;
    }

    public static void save(RacingCarGame racingCarGame) {
        RacingCarGameRepository.racingCarGame = racingCarGame;
    }
}
