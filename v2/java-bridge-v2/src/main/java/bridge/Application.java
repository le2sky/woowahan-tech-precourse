package bridge;

import bridge.common.seeder.DataSourceSeeder;
import bridge.controller.ControllerResolver;

public class Application {

    private static final ControllerResolver controllerResolver = new ControllerResolver();
    private static final DataSourceSeeder dataSourceSeeder = new DataSourceSeeder();

    public static void main(String[] args) {
        dataSourceSeeder.seed();
        controllerResolver.run();
    }
}
