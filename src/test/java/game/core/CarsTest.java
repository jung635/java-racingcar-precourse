package game.core;


import game.value.CarList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    @DisplayName("우승자 확인 메시지 테스트")
    void checkWinnerMessagesLength_ShouldBeBiggerThan0_True() {
        Cars cars = new Cars(new CarList("car1,car2"));
        cars.move();
        assertThat(cars.getWinnerMesssage().length()>0).isTrue();
    }

    @Test
    @DisplayName("게임 진행 상황 메시지 테스트")
    void checkMovingMessagesLength_ShouldBeBiggerThan0_True() {
        Cars cars = new Cars(new CarList("car1,car2"));
        assertThat(cars.move().length()>0).isTrue();
    }
}
