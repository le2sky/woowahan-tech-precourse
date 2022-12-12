package bridge.service;

import bridge.common.constant.BridgeDirection;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameHistory;
import bridge.repository.BridgeGameHistoryRepository;
import bridge.repository.BridgeGameRepository;

public class MoveBridgeService {

    public void move(BridgeDirection direction) {
        BridgeGame bridgeGame = BridgeGameRepository.find();
        BridgeGameHistory bridgeGameHistory = BridgeGameHistoryRepository.find();
        bridgeGame.move(direction, bridgeGameHistory);
    }

    public BridgeGameHistory getHistory() {
        return BridgeGameHistoryRepository.find();
    }
}
