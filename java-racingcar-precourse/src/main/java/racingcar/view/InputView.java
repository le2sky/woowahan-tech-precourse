package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public String readRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String read = readLine();
        validateNumberString(read);
        return read;
    }

    private void validateNumberString(String read) {
        if (!read.matches("^[0-9]*$"))
            throw new NotNumberStringException();
    }

    private String readLine() {
        return Console.readLine().replaceAll(" ", "");
    }

    public static class NotNumberStringException extends IllegalArgumentException {
    }
}
