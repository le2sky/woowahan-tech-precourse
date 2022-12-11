package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final String ONLY_NUMBER_MEESAGE = "숫자만 입력할 수 있습니다.";
    private final String READ_INVEST_MESSAGE = "구입금액을 입력해 주세요.";

    public String readInvestment() {
        System.out.println(READ_INVEST_MESSAGE);
        return readLine();
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
