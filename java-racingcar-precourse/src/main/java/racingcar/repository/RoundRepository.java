package racingcar.repository;

import racingcar.domain.Round;

public class RoundRepository {
    private static Round round;

    public static Round find() {
        return round;
    }

    public static void save(Round round) {
        RoundRepository.round = round;
    }
}
