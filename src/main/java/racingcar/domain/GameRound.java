package racingcar.domain;

import racingcar.exception.IllegalGameRoundException;

public class GameRound {
    private static final int MIN_GAME_ROUND = 0;
    private static final int MAX_GAME_ROUND = 20;
    private int gameRound;

    private GameRound(int gameRound) {
        validate(gameRound);
        this.gameRound = gameRound;
    }

    private void validate(int gameRound) {
        if (gameRound < MIN_GAME_ROUND || gameRound > MAX_GAME_ROUND) {
            String message = String.format("%d 이상 %d 이하의 회수를 입력해주세요.", MIN_GAME_ROUND, MAX_GAME_ROUND);
            throw new IllegalGameRoundException(message);
        }
    }

    public static GameRound createByGameRound(int gameRound) {
        return new GameRound(gameRound);
    }

    public void roundOver() {
        this.gameRound--;
    }

    public boolean isEnd() {
        return this.gameRound == 0;
    }
}
