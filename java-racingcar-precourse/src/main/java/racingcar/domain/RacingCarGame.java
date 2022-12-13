package racingcar.domain;

import racingcar.common.constants.GameState;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

    private final List<Car> cars = new ArrayList<>();
    private GameState gameState;

    public RacingCarGame() {
        this.gameState = GameState.PLAY;
    }

    public void arrange(CarGenerator carGenerator, List<String> names) {
        for (String name : names) {
            Car car = carGenerator.generate(name);
            cars.add(car);
        }
    }
}
