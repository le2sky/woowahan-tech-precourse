package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public String readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println("다리의 길이를 입력해주세요.");

        String read = readLine();
        validateNumberString(read);

        return read;
    }


    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return readLine();
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readLine();
    }


    private String readLine() {
        return Console.readLine().replaceAll(" ", "");
    }

    private void validateNumberString(String read) {
        try {
            Integer.parseInt(read);
        } catch (Exception e) {
            throw new NotNumberStringException();
        }
    }

    public static class NotNumberStringException extends IllegalArgumentException {
    }
}
