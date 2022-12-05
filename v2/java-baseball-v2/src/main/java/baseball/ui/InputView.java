package baseball.ui;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String ONLY_INPUT_NUMBER_MESSAGE = "숫자만 입력할 수 있습니다.";
    public static final String INPUT_USER_GUESSING_MESSAGE = "숫자를 입력해주세요 :";

    public String readUserGuessing() {
        System.out.print(INPUT_USER_GUESSING_MESSAGE);
        return getUserInputOrThrowing();
    }

    public String readRestartCommand() {
        return null;
    }

    private String getUserInputOrThrowing() {
        String input = readLineWithoutWhiteSpace();
        validateInputNumberString(input);
        return input;
    }

    private static String readLineWithoutWhiteSpace() {
        return Console.readLine().replaceAll(" ", "");
    }

    private void validateInputNumberString(String userGuessing) throws IllegalArgumentException {
        try {
            Integer.parseInt(userGuessing);
        } catch (Exception err) {
            throw new IllegalArgumentException(ONLY_INPUT_NUMBER_MESSAGE);
        }
    }
}
