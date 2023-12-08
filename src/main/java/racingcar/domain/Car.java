package racingcar.domain;

public class Car {
    private final CarName name;
    private final MoveCount moveCount;

    private Car(String name) {
        this.name = CarName.createByName(name);
        this.moveCount = new MoveCount();
    }

    public static Car createByName(String name) {
        return new Car(name);
    }

    public void moveByCondition(int condition) {
        moveCount.moveByCondition(condition);
    }

    public String getName() {
        return name.getName();
    }

    public int getCount() {
        return moveCount.getCount();
    }

    public String getMoveResult() {
        return name.getName()
                + " : "
                + moveCount.display();
    }
}
