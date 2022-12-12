package bridge.service;

import bridge.domain.BridgeGame;
import bridge.repository.BridgeGameRepository;

public class RoundCheckService {

    public boolean checkSuccess() {
        BridgeGame bridgeGame = BridgeGameRepository.find();
        return bridgeGame.isSuccess();
    }

    public boolean checkFail() {
        BridgeGame bridgeGame = BridgeGameRepository.find();
        return bridgeGame.isFail();
    }

    public boolean checkPlay() {
        BridgeGame bridgeGame = BridgeGameRepository.find();
        return bridgeGame.isPlay();
    }
}
