package lotto.domain;

public class Revenue {

    private final double amount;

    public Revenue(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%.1f", amount) + "%";
    }
}
