package racingcar.domain;

import racingcar.exception.IllegalCarNameException;

public class CarName {
    private static final int SIZE = 5;
    private final String name;

    private CarName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        String regex = String.format("^[a-z]{1,%s}$", SIZE);
        if (!name.matches(regex)) {
            throw new IllegalCarNameException();
        }
    }

    public static CarName createByName(String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
    }
}
