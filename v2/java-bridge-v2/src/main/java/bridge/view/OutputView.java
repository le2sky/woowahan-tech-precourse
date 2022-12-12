package bridge.view;

import bridge.common.constant.BridgeDirection;
import bridge.domain.BridgeGameHistory;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public void printMap(BridgeGameHistory history) {
        HashMap<BridgeDirection, List<String>> histories = history.getHistory();
        printResultByOneDirection(histories.get(BridgeDirection.UPPER));
        printResultByOneDirection(histories.get(BridgeDirection.LOWER));
    }

    public void printResult() {
    }

    private void printResultByOneDirection(List<String> pages) {
        String line = String.join(" | ", pages);
        String printLine = String.format("[ %s ]", line);
        System.out.println(printLine);
    }
}
