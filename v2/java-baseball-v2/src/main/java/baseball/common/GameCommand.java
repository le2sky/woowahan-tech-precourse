package baseball.common;

public enum GameCommand {

    RESTART(1), CLOSE(2);

    private final int value;

    GameCommand(int value) {
        this.value = value;
    }

    public boolean isRestartCommand(int input) {
        return input == RESTART.value;
    }

    public boolean isCloseCommand(int input) {
        return input == CLOSE.value;
    }
}
