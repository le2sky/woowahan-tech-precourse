package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomGeneratorTest {

    @Test
    void generate_6개_숫자를_반환한다() {
        RandomGenerator randomGenerator = new RandomGenerator();
        for (int i = 0; i < 10; i++) {
            List<Integer> generate = randomGenerator.generate();
            assertThat(generate.size()).isEqualTo(6);
        }
    }

    @Test
    void generate_반환되는_각_숫자는_45이하이다() {
        RandomGenerator randomGenerator = new RandomGenerator();
        for (int i = 0; i < 10; i++) {
            List<Integer> generate = randomGenerator.generate();
            for (Integer integer : generate) {
                assertThat(integer).isLessThanOrEqualTo(45);
            }
        }
    }

    @Test
    void generate_반환되는_각_숫자는_1이상이다() {
        RandomGenerator randomGenerator = new RandomGenerator();
        for (int i = 0; i < 10; i++) {
            List<Integer> generate = randomGenerator.generate();
            for (Integer integer : generate) {
                assertThat(integer).isGreaterThanOrEqualTo(1);
            }
        }
    }
}