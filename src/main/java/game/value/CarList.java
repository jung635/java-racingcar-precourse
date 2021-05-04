package game.value;

import common.code.GameErrorCode;
import game.core.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CarList {
    private List<Car> carList;
    private static final String CAR_SPLIT_REGEX = ",";
    private static final int MINIMUM_NUMBER_OF_CARS = 2;

    public CarList(String carNameInput) {
        this.carList = new ArrayList<Car>();
        String[] carNameInputArr = carNameInput.split(CAR_SPLIT_REGEX);

        throwInputFormatException(carNameInput);
        throwEmptyException(carNameInput, carNameInputArr);
        throwNumberOfCarException(carNameInputArr);
        throwDuplicatedCarNameException(carNameInputArr);

        for (String carName : carNameInputArr) {
            carList.add(new Car(new CarName(carName)));
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    private void throwEmptyException(String carNameInput, String[] carNameInputArr) {
        if(carNameInput == null || carNameInput.length() == 0
                || carNameInputArr == null || carNameInputArr.length == 0) {
            throw new IllegalArgumentException(GameErrorCode.EMPTY_CAR_NAME.getErrorMessage());
        }
    }

    private void throwInputFormatException(String carNameInput) {
        if(carNameInput.startsWith(CAR_SPLIT_REGEX) || carNameInput.endsWith(CAR_SPLIT_REGEX)) {
            throw new IllegalArgumentException(GameErrorCode.INVALID_CAR_INPUT_FORMAT.getErrorMessage());
        }
    }

    private void throwNumberOfCarException(String[] carNameInputArr) {
        if(carNameInputArr.length < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(GameErrorCode.INSUFFICIENT_NUMBER_OF_CAR.getErrorMessage());
        }
    }

    private void throwDuplicatedCarNameException(String[] carNameInputArr) {
        HashSet<String> carNameHashSet = new HashSet<>();
        int index = 0;

        while ((index < carNameInputArr.length) && !carNameHashSet.contains(carNameInputArr[index])) {
            carNameHashSet.add(carNameInputArr[index]);
            index ++;
        }

        if(carNameInputArr.length > index) {
            throw new IllegalArgumentException(GameErrorCode.DUPLICATED_CAR_NAME.getErrorMessage());
        }
    }
}
