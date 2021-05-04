package game.core;

import common.code.GameErrorCode;
import game.value.CarName;

public class Car implements Comparable<Car> {
    private CarName carName;
    private int position;

    private final static int MIN_MOVING_NUMBER = 0;
    private final static int MAX_MOVING_NUMBER = 9;
    private final static int MIN_MOVING_FORWARD = 4;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = 0;
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void move(int movingNumber) {
        if(movingNumber < MIN_MOVING_NUMBER || movingNumber > MAX_MOVING_NUMBER) {
            throw new IllegalArgumentException(GameErrorCode.INVALID_RANGE_OF_MOVING_NUMBER.getErrorMessage());
        }

        if(isForward(movingNumber)) {
            this.position ++;
        }
    }

    private boolean isForward(int movingNumber) {
        return movingNumber >= MIN_MOVING_FORWARD;
    }

    @Override
    public String toString() {
        StringBuilder resultMessageBuilder = new StringBuilder();
        resultMessageBuilder.append(this.carName.getName() + ":");
        for(int i=0; i<this.position; i++) {
            resultMessageBuilder.append("-");
        }
        return resultMessageBuilder.toString();
    }


    @Override
    public int compareTo(Car car) {
        return car.getPosition() - getPosition();
    }
}
