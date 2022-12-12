package bridge.service;

import bridge.common.constant.RestartableCommand;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameHistory;
import bridge.repository.BridgeGameHistoryRepository;
import bridge.repository.BridgeGameRepository;

public class RestartService {

    public void restart(RestartableCommand command) {
        BridgeGame bridgeGame = BridgeGameRepository.find();
        BridgeGameHistory history = BridgeGameHistoryRepository.find();

        if(command.isRestartCommand())
            bridgeGame.retry(history);
    }

    public boolean isRestarted() {
        BridgeGame bridgeGame = BridgeGameRepository.find();
        return bridgeGame.isPlay();
    }
}
