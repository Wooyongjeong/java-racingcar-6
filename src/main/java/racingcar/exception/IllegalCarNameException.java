package racingcar.exception;

public class IllegalCarNameException extends IllegalArgumentException {
    private static final String MESSAGE = "유효하지 않은 자동차 이름입니다.";

    public IllegalCarNameException() {
        super(MESSAGE);
    }
}
