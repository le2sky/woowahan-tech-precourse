package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.commom.validation.BridgeValidator;

import java.util.List;

public class BridgeManager {
    private final BridgeMaker bridgeMaker;
    private List<String> bridge;

    public BridgeManager(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    }

    public void setBridgeWithSize(int size) {
        BridgeValidator.isProperlyBridgeSize(size);
        bridge = this.bridgeMaker.makeBridge(size);
    }

    public boolean isMovable(String userCommand, int stage) {
        return bridge.get(stage).equals(userCommand);
    }
}
