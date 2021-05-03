package game.core;

import game.value.CarList;
import game.value.TryCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GamePlayerTest {

    @ParameterizedTest
    @DisplayName("자동차 게임 실행 확인_성공")
    @ValueSource(strings = {"car1, car2, car3"})
    void playGame(String carsInput) {
        GamePlayer gamePlayer = new GamePlayer(new CarList(carsInput));
        gamePlayer.playGame(new TryCount(5));
    }


}
