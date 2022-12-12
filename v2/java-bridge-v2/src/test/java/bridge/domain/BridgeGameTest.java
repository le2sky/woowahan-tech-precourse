package bridge.domain;

import bridge.common.constant.BridgeDirection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private static BridgeGame bridgeGame;
    private static BridgeGameHistory bridgeGameHistory;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "U")));
        bridgeGameHistory = new BridgeGameHistory();
    }

    @Test
    void move_건너기_성공일_경우_hisotry_가_direction_쪽에_O_shape_가_적힌다() {
        bridgeGame.move(BridgeDirection.UPPER, bridgeGameHistory);
        List<String> upperHistory = bridgeGameHistory.getHistory().get(BridgeDirection.UPPER);
        String source = upperHistory.get(0);
        assertThat(source).isEqualTo("O");
    }

    @Test
    void move_건너기_실패일_경우_hisotry_가_direction_쪽에_X_shape_가_적힌다() {
        bridgeGame.move(BridgeDirection.LOWER, bridgeGameHistory);
        List<String> upperHistory = bridgeGameHistory.getHistory().get(BridgeDirection.LOWER);
        String source = upperHistory.get(0);
        assertThat(source).isEqualTo("X");
    }

    @Test
    void move_다리를_모두_건너면_상태가_SUCCESS_로_변한다() {
        bridgeGame.move(BridgeDirection.UPPER, bridgeGameHistory);
        bridgeGame.move(BridgeDirection.LOWER, bridgeGameHistory);
        bridgeGame.move(BridgeDirection.UPPER, bridgeGameHistory);
        assertThat(bridgeGame.isSuccess()).isTrue();
    }

    @Test
    void move_다리를_건너는_중이면_PLAY_상태다() {
        bridgeGame.move(BridgeDirection.UPPER, bridgeGameHistory);
        assertThat(bridgeGame.isPlay()).isTrue();
    }

    @Test
    void move_다리_건너기를_실패하면_FAIL_상태로_변한다() {
        bridgeGame.move(BridgeDirection.UPPER, bridgeGameHistory);
        bridgeGame.move(BridgeDirection.UPPER, bridgeGameHistory);
        assertThat(bridgeGame.isFail()).isTrue();
    }

    @Test
    void write() {
    }
}