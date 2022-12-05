package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String ONLY_INPUT_NUMBER_MESSAGE = "숫자만 입력할 수 있습니다.";
    public static final String INPUT_USER_GUESSING_MESSAGE = "숫자를 입력해주세요 :";
    public static final String INPUT_RESTART_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String WHITE_SPACE = " ";

    public String readUserGuessing() {
        System.out.print(INPUT_USER_GUESSING_MESSAGE);
        return getUserInputOrThrowing();
    }

    public String readRestartCommand() {
        System.out.println(INPUT_RESTART_COMMAND_MESSAGE);
        return getUserInputOrThrowing();
    }

    private String getUserInputOrThrowing() {
        String input = readLineWithoutWhiteSpace();
        validateInputNumberString(input);
        return input;
    }

    private String readLineWithoutWhiteSpace() {
        return Console.readLine().replaceAll(WHITE_SPACE, "");
    }

    private void validateInputNumberString(String userGuessing) {
        try {
            Integer.parseInt(userGuessing);
        } catch (Exception err) {
            throw new IllegalArgumentException(ONLY_INPUT_NUMBER_MESSAGE);
        }
    }
}
