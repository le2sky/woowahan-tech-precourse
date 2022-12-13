package racingcar.view;

import racingcar.dto.RacingResultDto;
import racingcar.dto.WinnerResultDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OutputView {
    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printWinner(WinnerResultDto winner) {
        System.out.print("최종 우승자 : ");
        List<String> names = winner.getWinner();
        String winners = String.join(", ", names);
        System.out.println(winners);
    }

    public void printRacingResult(RacingResultDto moveResult) {
        HashMap<String, Integer> result = moveResult.getResult();
        Set<Map.Entry<String, Integer>> entries = result.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.printf("%s : " + getLines(entry.getValue()) + "%n", entry.getKey());
        }
        System.out.println();
    }

    private String getLines(Integer value) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < value; i++) {
            line.append("-");
        }

        return line.toString();
    }

    public void printError(Exception err) {
        System.out.println("[ERROR] " + err.getClass().getSimpleName());
    }
}
