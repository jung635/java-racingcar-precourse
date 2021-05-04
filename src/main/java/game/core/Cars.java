package game.core;

import game.value.CarList;

import java.util.*;

public class Cars {
    private CarList carList;
    private static final int BOUND_RANDOM_NUMBER = 10;

    public Cars(CarList carList) {
        this.carList = carList;
    }

    public String move() {
        StringBuilder movingMessage = new StringBuilder();

        for(Car car : this.carList.getCarList()) {
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
        Collections.sort(this.carList.getCarList());

        while((index < this.carList.getCarList().size()) && (this.carList.getCarList().get(index).getPosition() >= maxPosition)) {
            winnerList.add(this.carList.getCarList().get(index).getCarName().getName());
            maxPosition = this.carList.getCarList().get(index).getPosition();
            index ++;
        }

        return winnerList;
    }
}
