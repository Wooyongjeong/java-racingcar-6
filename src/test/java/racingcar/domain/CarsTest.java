package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.function.IntSupplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @DisplayName("자동차 이동 테스트")
    @Test
    public void moveCarsTest() {
        //given
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = Cars.createByCarNames(carNames);

        //when
        IntSupplier maxSupplier = () -> MoveCount.MAX_NUM;
        cars.moveCars(maxSupplier);

        //then
        List<String> expected = List.of("pobi : -", "woni : -", "jun : -");
        List<String> moveResults = cars.getMoveResults();
        assertThat(moveResults).isEqualTo(expected);
    }

    @DisplayName("최종 우승자 테스트")
    @Test
    public void getWinnersTest() {
        //given
        List<String> carNames = List.of("pobi", "woni", "jun");
        Cars cars = Cars.createByCarNames(carNames);

        //when
        IntSupplier maxSupplier = () -> MoveCount.MAX_NUM;
        cars.moveCars(maxSupplier);

        //then
        List<String> expected = List.of("pobi", "woni", "jun");
        List<String> winners = cars.getWinners();
        assertThat(winners).isEqualTo(expected);
    }
}