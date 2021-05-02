package game.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> carList;
    final static int BOUND_RANDOM_NUMBER = 10;

    public Cars(String carNameInput) {
        this.carList = new ArrayList<Car>();
        String[] carNameInputArr = carNameInput.split(",");

        for (String carName : carNameInputArr) {
            carList.add(new Car(carName));
        }
    }

    public String move() {
        StringBuilder movingMessage = new StringBuilder();

        for(Car car : this.carList) {
            car.move(new Random().nextInt(BOUND_RANDOM_NUMBER));
            movingMessage.append(car);
        }
        movingMessage.append("\n");

        return movingMessage.toString();
    }

    public String getWinnerMesssage() {
        if(getWinner().size() == 0) {
            return "우승자가 없습니다.";
        }

        String winnerMessage = String.join(",", getWinner());
        System.out.print(winnerMessage + "가 최종 우승했습니다.");

        return winnerMessage;
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
}
