package lotto.domain;

public class Money {

    private final String MONEY_RANGE_MESSAGE = "0보다 작을 수는 없습니다.";
    private final long amount;

    public Money(long amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    private void validateAmount(long amount) {
        if (amount < 0)
            throw new IllegalArgumentException(MONEY_RANGE_MESSAGE);
    }
}
