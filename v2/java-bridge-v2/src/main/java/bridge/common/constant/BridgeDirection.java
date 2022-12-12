package bridge.common.constant;

public enum BridgeDirection {

    UPPER(1, "U"), LOWER(0, "D");

    private final int index;
    private final String keyword;

    BridgeDirection(int index, String keyword) {
        this.index = index;
        this.keyword = keyword;
    }

    public int getIndex() {
        return index;
    }

    public String getKeyword() {
        return keyword;
    }

    public BridgeDirection otherwise() {
        if (this == LOWER)
            return UPPER;

        return LOWER;
    }

    public static BridgeDirection from(String direction) {
        if (direction.equals(UPPER.getKeyword()))
            return UPPER;

        if (direction.equals(LOWER.getKeyword()))
            return LOWER;

        throw new NotSupportDirectionCommandException();
    }

    public static class NotSupportDirectionCommandException extends IllegalArgumentException {
    }
}
