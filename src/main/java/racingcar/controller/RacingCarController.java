package racingcar.controller;

import racingcar.service.RacingCarService;

public class RacingCarController {
    private final RacingCarService racingCarService;

    public RacingCarController(RacingCarService racingCarService) {
        this.racingCarService = racingCarService;
    }

    public void play() {
        racingCarService.play();
    }
}
