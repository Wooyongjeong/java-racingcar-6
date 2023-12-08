package racingcar.exception;

public class IllegalGameRoundException extends IllegalArgumentException {
    private static final String MESSAGE = "유효하지 않은 시도 회수 값입니다.";

    public IllegalGameRoundException() {
        super(MESSAGE);
    }

    public IllegalGameRoundException(String message) {
        super(message);
    }
}
