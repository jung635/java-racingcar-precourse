package game.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 테스트_Exception")
    @ValueSource(strings = {",", "," ,",,"})
    void isValidCarName_ShouldBeThrowException(String carNameInput) {
        //new Cars(carNameInput);
        assertThatThrownBy(()->{
            new Cars(carNameInput);
        }, "자동차 이름 길이는 1~5자만 허용한다.").isInstanceOf(RuntimeException.class).hasMessage("Array of name of cars array is empty.");
    }

    @Test
    @DisplayName("우승자 확인 메시지 테스트")
    void checkWinnerMessagesLength_ShouldBeBiggerThan0_True() {
        Cars cars = new Cars("test1,test2");
        cars.move();
        assertThat(cars.getWinnerMesssage().length()>0).isTrue();
    }

    @Test
    @DisplayName("게임 진행 상황 메시지 테스트")
    void checkMovingMessagesLength_ShouldBeBiggerThan0_True() {
        Cars cars = new Cars("test1,test2");
        assertThat(cars.move().length()>0).isTrue();
    }
}
