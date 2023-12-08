package racingcar.domain;

import racingcar.exception.IllegalMoveConditionException;

public class MoveCount {
    public static final int MIN_NUM = 0;
    public static final int MAX_NUM = 9;
    private static final int MOVE_NUM = 4;
    private static final String DISPLAY = "-";
    private int count;

    public MoveCount() {
        this.count = 0;
    }

    public void moveByCondition(int condition) {
        validate(condition);
        if (condition < MOVE_NUM) {
            return;
        }
        count++;
    }

    private void validate(int condition) {
        if (condition < MIN_NUM || condition > MAX_NUM) {
            throw new IllegalMoveConditionException();
        }
    }

    public int getCount() {
        return count;
    }

    public String display() {
        return DISPLAY.repeat(count);
    }
}
