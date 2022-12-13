package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5)
            throw new NameOverLengthException();

        if (name.length() == 0)
            throw new UnknownCarNameException();
    }

    // 추가 기능 구현

    public static class NameOverLengthException extends IllegalArgumentException {
    }

    public static class UnknownCarNameException extends IllegalArgumentException {
    }
}
