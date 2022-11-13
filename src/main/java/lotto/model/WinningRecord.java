package lotto.model;

import java.util.List;

public class WinningRecord {
    private List<Integer> winningHistory;
    private long investment;

    public WinningRecord(List<Integer> winningHistory) {
        this.winningHistory = winningHistory;
        this.investment = winningHistory.stream().reduce(0, Integer::sum) * 1000;
    }

    public List<Integer> getWinningHistory() {
        return winningHistory;
    }

    public double getYield() {
        long totalReward = getTotalReward();
        return totalReward / (double) investment * 100;
    }

    private long getTotalReward() {
        Reward[] rewards = Reward.values();
        long totalReward = 0;
        for (Reward reward : rewards) {
            int amount = reward.getAmountAsInteger();
            int place = reward.getPlace();
            totalReward += ((long) amount * winningHistory.get(place));
        }
        return totalReward;
    }
}
