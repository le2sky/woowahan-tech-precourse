package bridge;

import bridge.common.constant.BridgeDirection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    private static BridgeMaker bridgeMaker;

    @BeforeAll
    static void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @ParameterizedTest(name = "[{index}] 사이즈가 {0}이라면 길이가 {0}인 다리를 반환")
    @ValueSource(ints = {2, 3, 4, 5, 6, 7, 7})
    void makeBridge_입력한_사이즈의_리스트를_반환한다(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        assertThat(bridge.size()).isEqualTo(size);
    }

    @Test
    void makeBridge_다리는_U_또는_D로_이루어졌다() {
        List<String> bridge = bridgeMaker.makeBridge(5);
        int size = (int) bridge.stream()
                .filter(BridgeDirection::isBridgeDirection)
                .count();

        assertThat(size).isEqualTo(5);
    }


    @Test
    void makeBridge_다리_길이가_양수가_아니라면_예외발생() {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}