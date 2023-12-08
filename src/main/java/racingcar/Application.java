package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.service.InputService;
import racingcar.service.OutputService;
import racingcar.service.RacingCarService;
import racingcar.view.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputValidator inputValidator = new InputValidator();
        InputView inputView = new InputView(inputValidator);
        OutputView outputView = new OutputView();

        InputService inputService = new InputService(inputView);
        OutputService outputService = new OutputService(outputView);
        RacingCarService racingCarService = new RacingCarService(inputService, outputService);

        RacingCarController racingCarController = new RacingCarController(racingCarService);
        racingCarController.play();
    }
}
