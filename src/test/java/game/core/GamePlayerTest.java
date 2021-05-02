package game.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class GamePlayerTest {

    final int MIN_TRY_COUNT = 1;

    @ParameterizedTest
    @DisplayName("시도 횟수 입력 확인_성공")
    @ValueSource(ints = {1,2})
    void isValidTryCount_ShouldBeFrom1To5_Success(int tryCount) {
        new GamePlayer(tryCount, "myCar");
    }

    @ParameterizedTest
    @DisplayName("시도 횟수 입력 확인_실패")
    @ValueSource(ints = {-1,0})
    void isValidTryCount_ShouldBeFrom1To5_Fail(int tryCount) {
        assertThatThrownBy(() -> {
            new GamePlayer(tryCount, "myCar");
        },"게임 시도 횟수는 양수만 허용된다. ").isInstanceOf(RuntimeException.class).hasMessage("Invalid input range: Count of try should be bigger than " + MIN_TRY_COUNT);
    }

    @ParameterizedTest
    @DisplayName("자동차 게임 실행 확인_성공")
    @ValueSource(strings = {"test,test2,test3"})
    void playGame(String carsInput) {
        GamePlayer gamePlayer = new GamePlayer(5, carsInput);
        gamePlayer.plyaGame();
    }


}
