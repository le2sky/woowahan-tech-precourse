package bridge.service;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameHistory;
import bridge.dto.GameHistoryDto;
import bridge.dto.GameResultDto;
import bridge.repository.BridgeGameHistoryRepository;
import bridge.repository.BridgeGameRepository;

public class ShowResultService {
    public GameResultDto getResult() {
        BridgeGame bridgeGame = BridgeGameRepository.find();
        return bridgeGame.result();
    }

    public GameHistoryDto getHistory() {
        BridgeGameHistory history = BridgeGameHistoryRepository.find();
        return history.build();
    }
}
