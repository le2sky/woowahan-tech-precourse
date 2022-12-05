package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameAnswerGeneratorImpl implements BaseballGameAnswerGenerator {

    @Override
    public BaseballGameAnswer generateRandomAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return new BaseballGameAnswer(computer);
    }

    @Override
    public BaseballGameAnswer generateAnswerFromInput(String input) {
        List<Integer> guessing = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        return new BaseballGameAnswer(guessing);
    }
}
