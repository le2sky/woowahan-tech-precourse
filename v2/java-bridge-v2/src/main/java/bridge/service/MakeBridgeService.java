package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.repository.BridgeGameRepository;

public class MakeBridgeService {
    private final BridgeMaker bridgeMaker;

    public MakeBridgeService() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void make(int size) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        BridgeGameRepository.save(bridgeGame);
    }
}
