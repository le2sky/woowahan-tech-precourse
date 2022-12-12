package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.repository.BridgeRepository;

public class MakeBridgeService {
    private final BridgeMaker bridgeMaker;

    public MakeBridgeService() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void make(int size) {
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(size));
        BridgeRepository.save(bridge);
    }
}
