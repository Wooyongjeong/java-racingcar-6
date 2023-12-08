package racingcar.view;

public class OutputView {
    public void printStartGameRound() {
        System.out.println("실행 결과");
    }

    public void printMoveResult(String moveResult) {
        System.out.println(moveResult);
    }

    public void printWinners(String winnerNames) {
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
