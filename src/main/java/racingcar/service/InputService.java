package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.GameRound;
import racingcar.view.InputView;

public class InputService {
    private final InputView inputView;

    public InputService(InputView inputView) {
        this.inputView = inputView;
    }

    public Cars inputCars() {
        List<String> carNames = inputView.inputCarNames();
        return Cars.createByCarNames(carNames);
    }

    public GameRound inputGameRound() {
        int gameRound = inputView.inputGameRound();
        return GameRound.createByGameRound(gameRound);
    }
}
