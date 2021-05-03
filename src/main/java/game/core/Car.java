package game.core;

import common.code.GameErrorCode;

public class Car implements Comparable<Car> {

    private String name;
    private int position;

    final static int MIN_LENGTH_CAR_NAME = 1;
    final static int MAX_LENGTH_CAR_NAME = 5;
    final static int MIN_MOVING_NUMBER = 0;
    final static int MAX_MOVING_NUMBER = 9;

    public Car(String name) {
        if(name.length() < MIN_LENGTH_CAR_NAME || name.length() > MAX_LENGTH_CAR_NAME) {
            throw new IllegalArgumentException(GameErrorCode.INVALID_LENGTH_OF_CAR_NAME.getErrorMessage());
        }

        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
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
        return movingNumber >= 4 && movingNumber <=9;
    }

    @Override
    public String toString() {
        StringBuilder resultMessageBuilder = new StringBuilder();
        resultMessageBuilder.append(this.name + ":");
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
