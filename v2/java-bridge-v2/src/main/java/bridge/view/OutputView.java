package bridge.view;

import bridge.common.constant.BridgeDirection;
import bridge.dto.GameHistoryDto;
import bridge.dto.GameResultDto;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public void printError(Exception err) {
        String[] names = err.getClass()
                .getName()
                .split("\\.");

        System.out.println("[ERROR] " + names[names.length - 1]);
    }

    public void printMap(GameHistoryDto history) {
        HashMap<BridgeDirection, List<String>> histories = history.getHistory();
        printResultByOneDirection(histories.get(BridgeDirection.UPPER));
        printResultByOneDirection(histories.get(BridgeDirection.LOWER));
    }

    public void printResult(GameResultDto result, GameHistoryDto history) {
        System.out.println("최종 게임 결과");
        printMap(history);
        System.out.println("게임 성공 여부: " + result.getBridgeGameProgress().getStatus());
        System.out.println("총 시도한 횟수: " + result.getRetry());
    }


    private void printResultByOneDirection(List<String> pages) {
        String line = String.join(" | ", pages);
        String printLine = String.format("[ %s ]", line);
        System.out.println(printLine);
    }
}
