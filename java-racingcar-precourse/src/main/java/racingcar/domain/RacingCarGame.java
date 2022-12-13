package racingcar.domain;

import racingcar.common.constants.GameState;
import racingcar.common.constants.RacingState;
import racingcar.dto.RacingResultDto;
import racingcar.dto.WinnerResultDto;

import java.util.ArrayList;
import java.util.HashMap;
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

    public boolean isGameEnd() {
        return gameState == GameState.END;
    }

    public WinnerResultDto winner() {
        List<String> winner = new ArrayList<>();
        int maxPosition = getMaxPosition();
        for (Car car : cars)
            if (car.getPosition() == maxPosition)
                winner.add(car.getName());

        return new WinnerResultDto(winner);
    }


    public RacingResultDto move(Round round, RandomNumberGenerator randomNumberGenerator) {
        moveAllCars(randomNumberGenerator);
        round.endOneRound();

        if (round.isAllRoundEnd())
            end();
        return getRacingResultDto();
    }

    private void moveAllCars(RandomNumberGenerator randomNumberGenerator) {
        for (Car car : cars) {
            if (isMovable(getRacingState(randomNumberGenerator)))
                car.move();
        }
    }

    private boolean isMovable(RacingState racingState) {
        return racingState.equals(RacingState.GO);
    }

    private RacingResultDto getRacingResultDto() {
        HashMap<String, Integer> readonly = new HashMap<>();
        for (Car car : cars) {
            readonly.put(car.getName(), car.getPosition());
        }

        return new RacingResultDto(readonly);
    }

    private RacingState getRacingState(RandomNumberGenerator randomNumberGenerator) {
        int random = randomNumberGenerator.generate();
        if (random >= 4)
            return RacingState.GO;

        return RacingState.STOP;
    }

    private int getMaxPosition() {
        int maxPosition = -1;
        for (Car car : cars) {
            int position = car.getPosition();
            if (position >= maxPosition)
                maxPosition = position;
        }

        return maxPosition;
    }

    private void end() {
        this.gameState = GameState.END;
    }
}
