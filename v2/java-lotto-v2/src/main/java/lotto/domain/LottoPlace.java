package lotto.domain;

public enum LottoPlace {

    FIRST(2_000_000_000, "1등: 6개 번호 일치"),
    SECOND(30_000_000, "2등: 5개 번호 + 보너스 번호 일치"),
    THIRD(1_500_000, "3등: 5개 번호 일치"),
    FOURTH(50_000, "4등: 4개 번호 일치"),
    FIFTH(5_000, "5등: 3개 번호 일치"),
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
