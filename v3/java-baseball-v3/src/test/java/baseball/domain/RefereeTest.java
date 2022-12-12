package baseball.domain;

import baseball.dto.BaseballGameResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    private static Referee referee;

    @BeforeEach
    void setUp() {
        referee = new Referee();
        referee.decideAnswer(new BaseballNumber(List.of(1, 2, 3)));
    }

    @ParameterizedTest(name = "[{index}] 스트라이크 테스트 -> {0}이 주어진다면 스트라이크 갯수는 {1}이어야 한다. ")
    @CsvSource(value = {"1,2,3:3", "1,2,4:2", "1,4,5:1"}, delimiter = ':')
    void judge_스트라이크_테스트(String source, int expected) {
        List<Integer> numbers = Arrays.stream(source.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        BaseballNumber guess = new BaseballNumber(numbers);
        BaseballGameResultDto dto = referee.judge(guess);
        assertThat(dto.getStrike()).isEqualTo(expected);
    }

    @ParameterizedTest(name = "[{index}] 볼 테스트 -> {0}이 주어진다면 볼 갯수는 {1}이어야 한다. ")
    @CsvSource(value = {"3,1,2:3", "8,1,2:2", "4,5,1:1", "1,3,5:1"}, delimiter = ':')
    void judge_볼_테스트(String source, int expected) {
        List<Integer> numbers = Arrays.stream(source.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        BaseballNumber guess = new BaseballNumber(numbers);
        BaseballGameResultDto dto = referee.judge(guess);
        assertThat(dto.getBall()).isEqualTo(expected);
    }
}