package bridge.common;

public enum BridgeDirection {

    UPPER(1, "U"), LOWWER(0, "D");

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

    public static boolean isBridgeDirection(String direction) {
        return direction.equals(UPPER.getKeyword()) ||
                direction.equals(LOWWER.getKeyword());
    }
}
