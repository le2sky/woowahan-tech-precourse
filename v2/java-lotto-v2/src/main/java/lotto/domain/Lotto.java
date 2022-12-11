package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new ArrayList<>(numbers);
        sortNumber();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contain(int target) {
        return numbers.contains(target);
    }

    private void validate(List<Integer> numbers) {
        validateNumbersLength(numbers);
        validateDuplicate(numbers);
        validateNumberRange(numbers);
    }

    private void validateNumbersLength(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException();
    }

    private void validateNumberRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45)
                throw new IllegalArgumentException("로또의 각 숫자 범위는 1이상 45이하입니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size())
            throw new IllegalArgumentException("로또 번호에는 중복되는 숫자가 있으면 안됩니다.");
    }

    private void sortNumber() {
        Collections.sort(numbers);
    }
}
