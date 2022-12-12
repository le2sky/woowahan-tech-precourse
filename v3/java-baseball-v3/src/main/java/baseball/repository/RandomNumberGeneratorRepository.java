package baseball.repository;


import baseball.domain.RandomNumberGenerator;

public class RandomNumberGeneratorRepository {
    private static RandomNumberGenerator randomNumberGenerator;

    public static void save(RandomNumberGenerator randomNumberGenerator) {
        RandomNumberGeneratorRepository.randomNumberGenerator = randomNumberGenerator;
    }

    public static RandomNumberGenerator find() {
        return RandomNumberGeneratorRepository.randomNumberGenerator;
    }
}
