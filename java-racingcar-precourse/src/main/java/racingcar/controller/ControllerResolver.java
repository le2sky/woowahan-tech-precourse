package racingcar.controller;

public class ControllerResolver {
    private final ArrangeCarController arrangeCarController;
    private final MoveCarController moveCarController;
    private final SetupRoundController setupRoundController;
    private final PrintErrorController printErrorController;

    private boolean isCarsSetted = false;
    private boolean isRoundSetted = false;

    public ControllerResolver() {
        this.arrangeCarController = new ArrangeCarController();
        this.moveCarController = new MoveCarController();
        this.setupRoundController = new SetupRoundController();
        this.printErrorController = new PrintErrorController();
    }

    public void run() {
        try {
            process();
        } catch (Exception e) {
            printErrorController.printError(e);
            // run(); -> 이거 이렇게 하면 안됌!
        }
    }

    private void process() {
        processArrangeCars();
        processSetupRound();
        processGameLogic();
    }

    private void processGameLogic() {
        moveCarController.showResultMessage();
        while (!moveCarController.isGameEnd())
            moveCarController.move();

        moveCarController.winner();
    }

    private void processSetupRound() {
        if (!isRoundSetted) {
            setupRoundController.setUp();
            isRoundSetted = true;
        }
    }

    private void processArrangeCars() {
        if (!isCarsSetted) {
            arrangeCarController.arrange();
            isCarsSetted = true;
        }
    }
}
