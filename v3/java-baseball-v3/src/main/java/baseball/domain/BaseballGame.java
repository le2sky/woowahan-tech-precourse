package baseball.domain;

public class BaseballGame {
    private GameState gameState;

    public BaseballGame(GameState gameState) {
        this.gameState = gameState;
    }

    public void changeMode(GameState gameState) {
        this.gameState = gameState;
    }
}
