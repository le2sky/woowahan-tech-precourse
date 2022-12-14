package bridge.domain;

import bridge.common.constant.BridgeDirection;
import bridge.dto.GameHistoryDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BridgeGameHistory {

    private final String FAIL_SHAPE = "X";
    private final String SUCCESS_SHAPE = "O";
    private final String EMPTY_SHAPE = " ";
    private HashMap<BridgeDirection, List<String>> history = new HashMap<>();

    public void writeSuccess(BridgeDirection direciton) {
        List<String> page = history.getOrDefault(direciton, new ArrayList<>());
        page.add(SUCCESS_SHAPE);
        history.put(direciton, page);
        writeOtherPage(direciton);
    }

    public void writeFail(BridgeDirection direciton) {
        List<String> page = history.getOrDefault(direciton, new ArrayList<>());
        page.add(FAIL_SHAPE);
        history.put(direciton, page);
        writeOtherPage(direciton);
    }

    public HashMap<BridgeDirection, List<String>> getHistory() {
        return history;
    }

    public void reset() {
        history = new HashMap<>();
    }

    public GameHistoryDto build() {
        HashMap<BridgeDirection, List<String>> readonly = new HashMap<>(history);
        return new GameHistoryDto(readonly);
    }

    private void writeOtherPage(BridgeDirection direction) {
        List<String> otherPage = history.getOrDefault(direction.otherwise(), new ArrayList<>());
        otherPage.add(EMPTY_SHAPE);
        history.put(direction.otherwise(), otherPage);
    }
}
