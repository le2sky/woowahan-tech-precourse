package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class BaseballNumber {

    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateDuplicate(numbers);
        validateNumbersSize(numbers);
        validateIncludeZero(numbers);
    }

    private void validateIncludeZero(List<Integer> numbers) {
        if (numbers.contains(0))
            throw new NotAllowZeroNumberException();
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != 3)
            throw new IllegalNumberLengthException();
    }

    private void validateDuplicate(List<Integer> numbers) {
        int origin = numbers.size();
        int target = new HashSet<>(numbers).size();

        if (origin != target)
            throw new DuplicateNumberException();
    }

    public static class IllegalNumberLengthException extends IllegalArgumentException {
    }

    public static class DuplicateNumberException extends IllegalArgumentException {
    }

    public static class NotAllowZeroNumberException extends IllegalArgumentException {
    }
}
