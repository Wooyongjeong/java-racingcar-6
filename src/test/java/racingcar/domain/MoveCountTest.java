package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveCountTest {
    @DisplayName("4 미만의 숫자에는 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void moveConditionUnderFourTest(int condition) {
        //given
        MoveCount moveCount = new MoveCount();

        //when
        moveCount.moveByCondition(condition);

        //then
        int expected = 0;
        int count = moveCount.getCount();
        assertThat(count).isEqualTo(expected);
    }

    @DisplayName("4 이상의 숫자라면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveConditionGreaterThanOrEqualToFourTest(int condition) {
        //given
        MoveCount moveCount = new MoveCount();

        //when
        moveCount.moveByCondition(condition);

        //then
        int expected = 1;
        int count = moveCount.getCount();
        assertThat(count).isEqualTo(expected);
    }

    @DisplayName("0 미만 9 초과의 숫자라면 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -57392, 10, 11, 947822})
    public void moveConditionExceptionTest(int condition) {
        //given
        MoveCount moveCount = new MoveCount();

        //when & then
        assertThatCode(() -> moveCount.moveByCondition(condition))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 전진 조건 값입니다.");
    }
}