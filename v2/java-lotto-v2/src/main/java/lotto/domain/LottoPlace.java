package lotto.domain;

public enum LottoPlace {
    FIFTH(5_000, "3개 일치 (5,000원)"),
    FOURTH(50_000, "4개 일치 (50,000원)"),
    THIRD(1_500_000, "5개 일치 (1,500,000원)"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원)"),
    LOST(0, "낙첨"),
    YET(0, "아직 추첨하지 않은 상태");

    private final int prize;
    private final String condition;

    LottoPlace(int prize, String condition) {
        this.prize = prize;
        this.condition = condition;

    }

    public String getCondition() {
        return condition;
    }

    public int getPrize() {
        return prize;
    }
}
