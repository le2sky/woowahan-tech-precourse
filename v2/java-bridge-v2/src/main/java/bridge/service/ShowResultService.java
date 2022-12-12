package bridge.service;

import bridge.domain.BridgeGame;
import bridge.dto.GameResultDto;
import bridge.repository.BridgeGameRepository;

public class ShowResultService {
    public GameResultDto getResult() {
        BridgeGame bridgeGame = BridgeGameRepository.find();
        return bridgeGame.result();
    }
}
