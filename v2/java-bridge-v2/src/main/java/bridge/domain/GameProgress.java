package bridge.domain;

public enum GameProgress {
    SUCCESS("성공"), FAIL("실패"), PLAY("진행중");

    private final String status;

    GameProgress(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
