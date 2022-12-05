package baseball.common;

public enum GameCommand {

    RESTART(1), CLOSE(2);

    private static final String WRONG_COMMAND = "잘못된 입력을 했습니다. 게임 시작 (1) / 게임 종료(2) 중 하나를 선택해 주세요.";
    private final int value;

    GameCommand(int value) {
        this.value = value;
    }

    public static boolean isRestartCommand(int input) {
        return input == RESTART.value;
    }

    public static boolean isCloseCommand(int input) {
        return input == CLOSE.value;
    }

    public static void validateWrongCommand(int input) throws IllegalArgumentException {
        if (!(isCloseCommand(input) || isRestartCommand(input)))
            throw new IllegalArgumentException(WRONG_COMMAND);
    }
}
