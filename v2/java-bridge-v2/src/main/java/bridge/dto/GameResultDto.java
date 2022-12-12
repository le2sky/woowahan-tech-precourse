package bridge.dto;

import bridge.common.constant.BridgeGameProgress;

public class GameResultDto {
    private final int retry;
    private final BridgeGameProgress bridgeGameProgress;

    public GameResultDto(int retry, BridgeGameProgress bridgeGameProgress) {
        this.retry = retry;
        this.bridgeGameProgress = bridgeGameProgress;
    }

    public int getRetry() {
        return retry;
    }

    public BridgeGameProgress getBridgeGameProgress() {
        return bridgeGameProgress;
    }
}
