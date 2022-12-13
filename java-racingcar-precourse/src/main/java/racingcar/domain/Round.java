package racingcar.domain;

public class Round {
    private int rest;

    public Round(int rest) {
        validateRest(rest);
        this.rest = rest;
    }

    public void endOneRound() {
        if (!isAllRoundEnd())
            rest--;
    }

    public boolean isAllRoundEnd() {
        return rest == 0;
    }

    private void validateRest(int rest) {
        if (rest < 0)
            throw new NegativeRoundException();
    }


    public static class NegativeRoundException extends IllegalArgumentException {
    }
}
