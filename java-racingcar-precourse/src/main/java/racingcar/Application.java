package racingcar;

import racingcar.common.seeder.DataSourceSeeder;
import racingcar.controller.ControllerResolver;

public class Application {

    private static ControllerResolver controllerResolver = new ControllerResolver();
    private static DataSourceSeeder dataSourceSeeder = new DataSourceSeeder();

    public static void main(String[] args) {
        dataSourceSeeder.seed();
        controllerResolver.run();
    }
}
