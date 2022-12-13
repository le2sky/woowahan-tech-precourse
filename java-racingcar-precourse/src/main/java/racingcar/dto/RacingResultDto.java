package racingcar.dto;

import java.util.HashMap;

public class RacingResultDto {
    private final HashMap<String, Integer> result;

    public RacingResultDto(HashMap<String, Integer> result) {
        this.result = result;
    }

    public HashMap<String, Integer> getResult() {
        return result;
    }
}
