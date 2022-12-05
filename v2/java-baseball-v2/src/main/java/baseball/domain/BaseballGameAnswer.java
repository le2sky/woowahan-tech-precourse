package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class BaseballGameAnswer {

    private static final String DUPLICATE_MESSAGE = "정답은 중복된 값으로 이루어질 수 없습니다.";
    private static final String NOT_IN_RANGE_NUMBER_MESSAGE = "각 숫자는 1부터 9 사이의 수입니다.";
    private static final String NUMBER_SIZE_MESSAGE = "적절한 갯수의 숫자를 입력해주세요. (갯수 제한): ";
    private static final int NUMBER_SIZE_LIMIT = 3;
    List<Integer> answer;

    public BaseballGameAnswer(List<Integer> answer) {
        validateDuplicatedNumber(answer);
        validateRangeNumber(answer);
        validateAnswerSize(answer);
        this.answer = answer;
    }

    public int getAnswerLength() {
        return answer.size();
    }

    private void validateDuplicatedNumber(List<Integer> answer) {
        int originSize = answer.size();
        int removeDuplicatedNumberSize = new HashSet<>(answer).size();
        if (originSize != removeDuplicatedNumberSize)
            throw new IllegalArgumentException(DUPLICATE_MESSAGE);
    }

    private void validateRangeNumber(List<Integer> answer) {
        for (Integer target : answer)
            if (target >= 0 && target <= 9)
                throw new IllegalArgumentException(NOT_IN_RANGE_NUMBER_MESSAGE);
    }

    private void validateAnswerSize(List<Integer> answer) {
        if (answer.size() != NUMBER_SIZE_LIMIT)
            throw new IllegalArgumentException(NUMBER_SIZE_MESSAGE + NUMBER_SIZE_LIMIT);
    }
}
