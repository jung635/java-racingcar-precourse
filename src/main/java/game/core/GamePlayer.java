package game.core;

import common.code.GameErrorCode;

public class GamePlayer {
    final int MIN_TRY_COUNT = 1;

    private final Cars cars;

    public GamePlayer(String carNameInput) {

        cars = new Cars(carNameInput);
    }

    public void playGame(int tryCount) {
        if(tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException(GameErrorCode.INVALID_RANGE_OF_TRY_COUNT.getErrorMessage());
        }

        for(int i=0; i<tryCount; i++){
            System.out.println(cars.move());
        }
        System.out.println(cars.getWinnerMesssage());
    }
}
