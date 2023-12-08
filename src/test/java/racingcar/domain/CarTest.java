package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    static Car car;

    @BeforeEach
    void beforeEach() {
        car = Car.createByName("test");
    }

    @DisplayName("실행 결과 테스트")
    @Test
    public void moveResultTest() throws Exception {
        //given
        List<Integer> conditions = List.of(3, 4, 9);

        //when
        conditions.forEach(condition -> car.moveByCondition(condition));

        //then
        String expected = "test : --";
        String moveResult = car.getMoveResult();
        assertThat(moveResult).isEqualTo(expected);
    }
}