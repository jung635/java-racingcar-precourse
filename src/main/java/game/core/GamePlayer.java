package game.core;

import game.value.CarList;
import game.value.TryCount;

/**
 * @brief
 * Game 진행 player
 */
public class GamePlayer {
    private final Cars cars;

    public GamePlayer(CarList carList) {
        cars = new Cars(carList);
    }

    public void playGame(TryCount tryCount) {
        System.out.println(); //게임 시작 전 줄바꿈
        for(int i=0; i<tryCount.getTryCount(); i++){
            System.out.println(cars.move()); // 게임 진행 상황 출력
        }
        System.out.println(cars.getWinnerMesssage()); // 게임 결과 출력
    }
}
