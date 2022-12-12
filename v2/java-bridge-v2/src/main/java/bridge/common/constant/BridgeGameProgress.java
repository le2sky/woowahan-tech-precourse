package bridge.common.constant;

public enum BridgeGameProgress {
    SUCCESS("성공"), FAIL("실패"), PLAY("진행중");

    private final String status;

    BridgeGameProgress(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
