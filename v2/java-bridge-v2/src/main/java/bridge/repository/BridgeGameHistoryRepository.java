package bridge.repository;

import bridge.domain.BridgeGameHistory;

public class BridgeGameHistoryRepository {
    private static BridgeGameHistory bridgeGameHistory;

    public static void save(BridgeGameHistory bridgeGameHistory) {
        BridgeGameHistoryRepository.bridgeGameHistory = bridgeGameHistory;
    }

    public static BridgeGameHistory find() {
        return BridgeGameHistoryRepository.bridgeGameHistory;
    }
}
