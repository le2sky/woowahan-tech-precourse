package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {


    @Test
    void validate_만약_중복수가_들어오면_예외발생() {
        assertThatThrownBy(() -> new BaseballNumber(List.of(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_만약_자리수가_3자리가_아니라면_예외발생() {
        assertThatThrownBy(() -> new BaseballNumber(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_만약_0이_포함되어_있으면_예외발생() {
        assertThatThrownBy(() -> new BaseballNumber(List.of(1, 2, 0)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}