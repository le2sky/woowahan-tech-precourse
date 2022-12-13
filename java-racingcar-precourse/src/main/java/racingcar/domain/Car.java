package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        position++;
    }

    private void validateName(String name) {
        if (name.length() > 5)
            throw new NameOverLengthException();

        if (name.length() == 0)
            throw new UnknownCarNameException();
    }

    public static class NameOverLengthException extends IllegalArgumentException {
    }

    public static class UnknownCarNameException extends IllegalArgumentException {
    }
}
