package bridge.common.constant;

public enum RestartableCommand {
    RESTART("R"), CLOSE("Q");

    private final String command;

    RestartableCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public boolean isRestartCommand() {
        return this.equals(RESTART);
    }

    public static RestartableCommand from(String command) {
        if (command.equals(RESTART.getCommand()))
            return RestartableCommand.RESTART;

        if (command.equals(CLOSE.getCommand()))
            return RestartableCommand.CLOSE;

        throw new NotSupportRestartableCommandException();
    }


    public static class NotSupportRestartableCommandException extends IllegalArgumentException {
    }

}
