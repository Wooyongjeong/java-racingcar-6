package racingcar.service;

import java.util.List;
import racingcar.common.Constants;
import racingcar.domain.Cars;
import racingcar.view.OutputView;

public class OutputService {
    private final OutputView outputView;

    public OutputService(OutputView outputView) {
        this.outputView = outputView;
    }

    public void startGameRound() {
        outputView.printStartGameRound();
    }

    public void printWinners(List<String> winners) {
        String winnerNames = String.join(Constants.COMMA_AND_SPACE, winners);
        outputView.printWinners(winnerNames);
    }

    public void printMoveResults(List<String> moveResults) {
        moveResults.forEach(outputView::printMoveResult);
        System.out.println();
    }
}
