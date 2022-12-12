package bridge.domain;

public class BridgeGameState {
    private int retry;
    private GameProgress progress;

    public BridgeGameState() {
        this.retry = 0;
        this.progress = GameProgress.PLAY;

    }

    public void increaseRetry() {
        retry++;
    }

    public void changeProgress(GameProgress gameProgress) {
        this.progress = gameProgress;
    }

    public int getRetry() {
        return retry;
    }

    public GameProgress getProgress() {
        return progress;
    }
}
