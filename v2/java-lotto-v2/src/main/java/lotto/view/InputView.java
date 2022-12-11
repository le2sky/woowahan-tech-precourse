package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {

    private final String COMMA_NUMBER_MESSAGE = "콤마로 구분된 숫자를 입력해주세요.";
    private final String READ_BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String READ_ANSWER_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String ONLY_NUMBER_MEESAGE = "숫자만 입력할 수 있습니다.";
    private final String READ_INVEST_MESSAGE = "구입금액을 입력해 주세요.";

    public String readInvestment() {
        System.out.println(READ_INVEST_MESSAGE);
        return readLine();
    }

    public String readBonus() {
        System.out.println(READ_BONUS_MESSAGE);
        return readLine();
    }


    public String readAnswer() {
        System.out.println(READ_ANSWER_NUMBER_MESSAGE);
        String input = Console.readLine().replaceAll(" ", "");
        validateAnswer(input);
        return input;
    }

    private void validateAnswer(String read) {
        List<String> values = List.of(read.split(","));
        try {
            for (String value : values) {
                Integer.parseInt(value);
            }
        } catch (Exception err) {
            throw new IllegalArgumentException(COMMA_NUMBER_MESSAGE);
        }
    }


    private String readLine() {
        String read = Console.readLine().replaceAll(" ", "");
        validateReadLine(read);

        return read;
    }

    private void validateReadLine(String read) {
        if (!read.matches("^[0-9]*$"))
            throw new IllegalArgumentException(ONLY_NUMBER_MEESAGE);
    }
}
