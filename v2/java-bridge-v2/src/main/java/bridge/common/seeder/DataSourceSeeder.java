package bridge.common.seeder;

import bridge.domain.BridgeGameHistory;
import bridge.repository.BridgeGameHistoryRepository;

public class DataSourceSeeder {

    public void seeding() {
        BridgeGameHistoryRepository.save(new BridgeGameHistory());
    }
}
