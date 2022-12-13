package racingcar.domain;

public class CarGenerator {

    public Car generate(String name) {
        return new Car(name);
    }
}
