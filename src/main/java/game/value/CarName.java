package game.value;

import common.code.GameErrorCode;

public class CarName {

    private String name;
    private final static int MIN_LENGTH_CAR_NAME = 1;
    private final static int MAX_LENGTH_CAR_NAME = 5;

    public CarName(String name) {
        throwInvalidLengthofCarName(name);
        this.name = name;
    }

    private void throwInvalidLengthofCarName(String name) {
        if(name.length() < MIN_LENGTH_CAR_NAME || name.length() > MAX_LENGTH_CAR_NAME) {
            throw new IllegalArgumentException(GameErrorCode.INVALID_LENGTH_OF_CAR_NAME.getErrorMessage());
        }
    }

    public String getName() {
        return name;
    }
}
