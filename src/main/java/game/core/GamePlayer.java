package game.core;

import common.validatation.Validator;

public class GamePlayer {
    final int MIN_TRY_COUNT = 1;

    private int tryCount;
    private Cars cars;

    public GamePlayer(int tryCount, String carNameInput) {
        Validator.isValidMinRange("Count of try", tryCount, MIN_TRY_COUNT);
        this.tryCount = tryCount;
        cars = new Cars(carNameInput);
    }

    public void plyaGame() {
        for(int i=0; i<tryCount; i++){
            System.out.println(cars.move());
        }
        System.out.println(cars.getWinnerMesssage());
    }
}
