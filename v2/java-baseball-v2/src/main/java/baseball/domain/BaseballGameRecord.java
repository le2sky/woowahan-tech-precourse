package baseball.domain;

public class BaseballGameRecord {

    private boolean isEnd;

    public BaseballGameRecord() {
        this.isEnd = false;
    }

    public boolean isGameEnd() {
        return isEnd;
    }

    public void changeGameState() {
        isEnd = !isEnd;
    }
}
