package racingcar.view;

import java.util.Arrays;
import racingcar.common.Constants;
import racingcar.exception.IllegalCarNameException;
import racingcar.exception.IllegalGameRoundException;

public class InputValidator {
    public void validateCarNames(String input) {
        if (!input.matches("^([a-z0-9]+)+(,[a-z0-9]+)+?$")) {
            throw new IllegalCarNameException();
        }
    }

    public void validateGameRound(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalGameRoundException();
        }
    }
}
