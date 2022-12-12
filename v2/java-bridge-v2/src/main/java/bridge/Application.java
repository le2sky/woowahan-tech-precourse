package bridge;

import bridge.common.seeder.DataSourceSeeder;
import bridge.controller.MakeBridgeController;
import bridge.controller.MoveBridgeController;

public class Application {

    public static void main(String[] args) {
        MakeBridgeController makeBridgeController = new MakeBridgeController();
        MoveBridgeController moveBridgeController = new MoveBridgeController();
        DataSourceSeeder dataSourceSeeder = new DataSourceSeeder();
        dataSourceSeeder.seeding();
        makeBridgeController.make();
        moveBridgeController.move();
    }
}
