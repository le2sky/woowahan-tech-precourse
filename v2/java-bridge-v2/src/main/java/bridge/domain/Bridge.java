package bridge.domain;

import bridge.common.constant.BridgeDirection;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        validateBridgeSize(bridge);
        validateBridgeFloor(bridge);
        this.bridge = bridge;
    }

    public boolean isMovable(int nowFloor, BridgeDirection direction) {
        return bridge.get(nowFloor).equals(direction.getKeyword());
    }

    public boolean isPassed(int nowFloor) {
        return nowFloor == bridge.size() - 1;
    }

    private void validateBridgeFloor(List<String> bridge) {
        for (String floor : bridge)
            BridgeDirection.from(floor);
    }

    private void validateBridgeSize(List<String> bridge) {
        if (bridge.size() < 3)
            throw new RangeUnderFlowException();
        if (bridge.size() > 20)
            throw new RangeOverFlowException();
    }

    public static class RangeOverFlowException extends IllegalArgumentException {
    }

    public static class RangeUnderFlowException extends IllegalArgumentException {
    }
}

