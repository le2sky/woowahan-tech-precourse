package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RaffleMachineTest {

    private static RaffleMachine raffleMachine;

    @BeforeEach
    void init() {
        raffleMachine = new RaffleMachine();
    }

    @Test
    void decideAnswer_1이하의_보너스숫자를_입력하면_예외발생() {
        assertThatThrownBy(() -> raffleMachine.decideAnswer(List.of(1, 2, 3, 4, 5, 6), 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void decideAnswer_45이상의_보너스숫자를_입력하면_예외발생() {
        assertThatThrownBy(() -> raffleMachine.decideAnswer(List.of(1, 2, 3, 4, 5, 6), 46))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void decideAnswer_정답_숫자에_보너스숫자가_포함되면_예외발생() {
        assertThatThrownBy(() -> raffleMachine.decideAnswer(List.of(1, 2, 3, 4, 5, 6), 3))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void decideAnswer_정답_숫자에_중복숫자가_포함되면_예외발생() {
        assertThatThrownBy(() -> raffleMachine.decideAnswer(List.of(1, 3, 3, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void decideAnswer_정답_숫자의_각_숫자중_하나라도_45이상이면_예외발생() {
        assertThatThrownBy(() -> raffleMachine.decideAnswer(List.of(1, 3, 48, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void decideAnswer_정답_숫자의_각_숫자중_하나라도_1이하면_예외발생() {
        assertThatThrownBy(() -> raffleMachine.decideAnswer(List.of(1, 3, 0, 4, 5, 6), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void draw_모든_숫자가_맞으면_1등을_반환() {
        raffleMachine.decideAnswer(List.of(1, 2, 3, 4, 5, 6), 7);
        LottoPlace result = raffleMachine.draw(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

//        System.out.println(result.getPrize());
       // assertThat(result).isEqualTo(LottoPlace.FIRST);
    }
}