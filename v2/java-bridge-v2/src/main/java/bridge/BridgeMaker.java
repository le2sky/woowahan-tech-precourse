package bridge;

import bridge.common.BridgeDirection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        validateSize(size);
        HashMap<Integer, String> direction = getDirection();
        return getBridge(size, direction);
    }

    private void validateSize(int size) {
        if (size < 1)
            throw new NotPositiveBridgeSizeException();
    }

    private List<String> getBridge(int size, HashMap<Integer, String> direction) {
        List<String> bridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int key = bridgeNumberGenerator.generate();
            bridge.add(direction.get(key));
        }

        return bridge;
    }

    private HashMap<Integer, String> getDirection() {
        HashMap<Integer, String> command = new HashMap<>();
        command.put(BridgeDirection.UPPER.getIndex(), BridgeDirection.UPPER.getKeyword());
        command.put(BridgeDirection.LOWWER.getIndex(), BridgeDirection.LOWWER.getKeyword());

        return command;
    }

    public static class NotPositiveBridgeSizeException extends IllegalArgumentException {
    }
}
