package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createByCarNames(List<String> carNames) {
        List<Car> cars = carNames.stream()
                .map(Car::createByName)
                .toList();
        return new Cars(cars);
    }

    public void moveCars() {
        cars.forEach(car -> {
            int condition = Randoms.pickNumberInRange(MoveCount.MIN_NUM, MoveCount.MAX_NUM);
            car.moveByCondition(condition);
        });
    }

    public List<String> getMoveResults() {
        return cars.stream()
                .map(Car::getMoveResult)
                .toList();
    }

    private int getMaxCount() {
        return cars.stream()
                .mapToInt(Car::getCount)
                .max()
                .orElse(0);
    }

    public List<String> getWinners() {
        int maxCount = getMaxCount();
        return cars.stream()
                .filter(car -> car.getCount() == maxCount)
                .map(Car::getName)
                .toList();
    }
}
