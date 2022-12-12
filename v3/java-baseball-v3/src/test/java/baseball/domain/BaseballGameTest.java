package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameTest {

    @Test
    void chnageMode_숫자를_전부_맞추면_게임이_종료된다() {
        BaseballGame baseballGame = new BaseballGame(GameState.PLAY);
        Referee referee = new Referee();
        referee.decideAnswer(new BaseballNumber(List.of(1,2,3)));
        baseballGame.judge(new BaseballNumber(List.of(1,2,3)), referee);

        assertThat(baseballGame.isGameEnd()).isTrue();
    }
}