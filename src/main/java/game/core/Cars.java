package game.core;

import common.code.GameErrorCode;

import java.util.*;

public class Cars {
    private List<Car> carList;
    private static final int BOUND_RANDOM_NUMBER = 10;
    private static final String CAR_SPLIT_REGEX = ",";
    private static final int MINIMUM_NUMBER_OF_CARS = 2;

    public Cars(String carNameInput) {
        this.carList = new ArrayList<Car>();
        String[] carNameInputArr = carNameInput.split(CAR_SPLIT_REGEX);

        throwInputFormatException(carNameInput);
        throwEmptyException(carNameInput, carNameInputArr);
        throwNumberOfCarException(carNameInputArr);
        throwDuplicatedCarNameException(carNameInputArr);

        for (String carName : carNameInputArr) {
            carList.add(new Car(carName));
        }
    }

    public String move() {
        StringBuilder movingMessage = new StringBuilder();

        for(Car car : this.carList) {
            car.move(new Random().nextInt(BOUND_RANDOM_NUMBER));
            movingMessage.append(car+"\n");
        }

        return movingMessage.toString();
    }

    public String getWinnerMesssage() {
        if(getWinner().size() == 0) {
            return "우승자가 없습니다.";
        }

        return String.join(",", getWinner()) + "가 최종 우승했습니다.";
    }

    private ArrayList<String> getWinner() {
        ArrayList<String> winnerList = new ArrayList<String>();
        int maxPosition = 0;
        int index = 0;

        //position 대상 내림차순
        Collections.sort(this.carList);

        while((index < this.carList.size()) && (this.carList.get(index).getPosition() >= maxPosition)) {
            winnerList.add(this.carList.get(index).getName());
            maxPosition = this.carList.get(index).getPosition();
            index ++;
        }

        return winnerList;
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
