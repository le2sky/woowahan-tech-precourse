package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
    void validate_다리의_구성요소가_U_또는_D가_아니면_예외발생() {
        ArrayList<String> target = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            target.add("U");
        }
        assertThatThrownBy(() -> new Bridge(List.of("a", "B", "U")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}