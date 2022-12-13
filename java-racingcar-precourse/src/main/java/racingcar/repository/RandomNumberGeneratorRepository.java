package racingcar.repository;

import racingcar.domain.RandomNumberGenerator;

public class RandomNumberGeneratorRepository {

    private static  RandomNumberGenerator randomNumberGenerator;

    public static RandomNumberGenerator find() {
        return randomNumberGenerator;
    }

    public static void save(RandomNumberGenerator randomNumberGenerator) {
        RandomNumberGeneratorRepository.randomNumberGenerator = randomNumberGenerator;
    }
}
