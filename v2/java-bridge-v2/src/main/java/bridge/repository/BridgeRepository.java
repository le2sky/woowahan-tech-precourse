package bridge.repository;

import bridge.domain.Bridge;

public class BridgeRepository {

    private static Bridge bridge;

    public static void save(Bridge bridge) {
        BridgeRepository.bridge = bridge;
    }

    public static Bridge find() {
        return BridgeRepository.bridge;
    }
}
