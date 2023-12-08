package racingcar.exception;

public class IllegalMoveConditionException extends IllegalArgumentException {
    private static final String MESSAGE = "유효하지 않은 전진 조건 값입니다.";

    public IllegalMoveConditionException() {
        super(MESSAGE);
    }
}
