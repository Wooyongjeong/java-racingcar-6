package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameRoundTest {
    @DisplayName("정상 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 20})
    public void createTest(int gameRound) {
        assertThatCode(() -> GameRound.createByGameRound(gameRound))
                .doesNotThrowAnyException();
    }

    @DisplayName("0 이상 20 이하의 숫자가 아니라면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -20, 21, 25, 100})
    public void notInRangeTest(int gameRound) {
        assertThatCode(() -> GameRound.createByGameRound(gameRound))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0 이상 20 이하의 회수를 입력해주세요.");
    }

    @DisplayName("라운드 지남 테스트")
    @Test
    public void roundOverTest() {
        //given
        int round = 1;
        GameRound gameRound = GameRound.createByGameRound(round);

        //when
        gameRound.roundOver();

        //then
        boolean expected = true;
        assertThat(gameRound.isEnd()).isEqualTo(expected);
    }
}