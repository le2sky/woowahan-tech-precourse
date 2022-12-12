package bridge.dto;

import bridge.common.constant.BridgeDirection;

import java.util.HashMap;
import java.util.List;

public class GameHistoryDto {

    private final HashMap<BridgeDirection, List<String>> history;

    public GameHistoryDto(HashMap<BridgeDirection, List<String>> history) {
        this.history = history;
    }

    public HashMap<BridgeDirection, List<String>> getHistory() {
        return history;
    }
}
