package bridge.repository;

import bridge.domain.BridgeGame;

public class BridgeGameRepository {

    private static BridgeGame bridgeGame;

    public static void save(BridgeGame bridgeGame) {
        BridgeGameRepository.bridgeGame = bridgeGame;
    }

    public static BridgeGame find() {
        return BridgeGameRepository.bridgeGame;
    }
}
