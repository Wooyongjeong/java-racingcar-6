package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.common.Constants;

public class InputView {
    private final InputValidator inputValidator;

    public InputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        inputValidator.validateCarNames(input);
        return Arrays.stream(input.split(Constants.COMMA))
                .toList();
    }

    public int inputGameRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        inputValidator.validateGameRound(input);
        return Integer.parseInt(input);
    }
}
