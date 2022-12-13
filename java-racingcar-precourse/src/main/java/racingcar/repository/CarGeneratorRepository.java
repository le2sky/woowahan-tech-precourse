package racingcar.repository;

import racingcar.domain.CarGenerator;

public class CarGeneratorRepository {

    private static CarGenerator carGenerator;

    public static CarGenerator find() {
        return carGenerator;
    }

    public static void save(CarGenerator carGenerator) {
        CarGeneratorRepository.carGenerator = carGenerator;
    }
}
