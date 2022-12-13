package racingcar.dto;

import java.util.List;

public class WinnerResultDto {
    private final List<String> winner;

    public WinnerResultDto(List<String> winner) {
        this.winner = winner;
    }

    public List<String> getWinner() {
        return winner;
    }
}
