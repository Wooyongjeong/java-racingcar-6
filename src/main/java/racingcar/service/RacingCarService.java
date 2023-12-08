package racingcar.service;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.GameRound;

public class RacingCarService {
    private final InputService inputService;
    private final OutputService outputService;

    public RacingCarService(InputService inputService, OutputService outputService) {
        this.inputService = inputService;
        this.outputService = outputService;
    }

    public void play() {
        // 자동차 이름을 입력 받는다.
        Cars cars = inputService.inputCars();
        // 시도할 회수를 입력 받는다.
        GameRound gameRound = inputService.inputGameRound();

        // 시도할 회수만큼 자동차를 이동시킨다.
        moveCarsUntilGameRoundOver(cars, gameRound);

        // 최종 우승자를 출력한다.
        List<String> winners = cars.getWinners();
        outputService.printWinners(winners);
    }

    private void moveCarsUntilGameRoundOver(Cars cars, GameRound gameRound) {
        outputService.startGameRound();
        while (!gameRound.isEnd()) {
            cars.moveCars();
            List<String> moveResults = cars.getMoveResults();
            outputService.printMoveResults(moveResults);
            gameRound.roundOver();
        }
    }
}
