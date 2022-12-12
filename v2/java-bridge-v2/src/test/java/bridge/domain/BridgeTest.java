package bridge.domain;

import bridge.common.constant.BridgeDirection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    @Test
    void validate_다리의_길이가_3미만_이라면_예외발생() {
        assertThatThrownBy(() -> new Bridge(List.of("D", "U")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_다리의_길이가_20초과_이라면_예외발생() {
        ArrayList<String> target = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            target.add("U");
        }
        assertThatThrownBy(() -> new Bridge(target))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isMovable_현재_다리에_주어진_방향으로_건널수있으면_참을_반환() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        boolean movable = bridge.isMovable(0, BridgeDirection.UPPER);
        assertThat(movable).isTrue();
    }

    @Test
    void isMovable_현재_다리에_주어진_방향으로_건널수있으면_거짓을_반환() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        boolean movable = bridge.isMovable(0, BridgeDirection.LOWER);
        assertThat(movable).isFalse();
    }

    @Test
    void validate_다리의_구성요소가_U_또는_D가_아니면_예외발생() {
        assertThatThrownBy(() -> new Bridge(List.of("a", "D", "U")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}