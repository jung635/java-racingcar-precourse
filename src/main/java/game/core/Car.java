package game.core;

import common.validatation.Validator;

public class Car implements Comparable<Car> {

    private String name;
    private int position;

    final static int MAX_LENGTH_CAR_NAME = 1;
    final static int MIN_LENGTH_CAR_NAME = 5;

    public Car(String name) {
        Validator.isValidStringLength("Name of cars", name, MAX_LENGTH_CAR_NAME, MIN_LENGTH_CAR_NAME);

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
        Validator.isValidRange("Moving number", movingNumber, 0, 9);

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
