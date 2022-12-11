package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoMachineTest {

    private static LottoMachine lottoMachine;

    @BeforeAll
    static void init() {
        lottoMachine = new LottoMachine(new RandomGenerator());

    }

    @ParameterizedTest(name = "[{index}] 로또 발행 테스트 -> {0}원이 들어오면, {1}개의 로또 발행")
    @CsvSource(value = {"1000:1", "2000:2", "3000:3", "4000:4"}, delimiter = ':')
    void produce_주어진_가격에_맞게_로또를_발행한다(int amount, int expected) {
        Money money = new Money(amount);
        List<Lotto> lottos = lottoMachine.produce(money);
        assertThat(lottos.size()).isEqualTo(expected);
    }

    @Test
    void validate_최소_로또_가격_보다_입력값이_낮으면_예외_발생() {
        assertThatThrownBy(() -> lottoMachine.produce(new Money(500)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 한장도 구매 못하는 투자금입니다.");
    }
}