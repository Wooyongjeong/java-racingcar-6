package racingcar.domain;

import java.util.List;

public class CarManager {

    private final List<Car> cars;
    private int maxCount;

    private CarManager(List<Car> cars) {
        this.cars = cars;
        this.maxCount = 0;
    }

    public static CarManager createFromInputCarNames(String inputCarNames) {
        List<String> carNames = NameSeparator.separateNamesByComma(inputCarNames);
        List<Car> cars = carNames.stream().map(Car::createFromName).toList();
        return new CarManager(cars);
    }

    public void orderCarsMoveForward() {
        cars.forEach(car -> {
            car.moveForward();
            updateMaxCount(car.getMoveForwardCount());
        });
    }

    private void updateMaxCount(int count) {
        this.maxCount = Math.max(count, this.maxCount);
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getMoveForwardCount() == maxCount)
                .toList();
    }

}
