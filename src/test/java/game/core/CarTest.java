package game.core;

import common.code.GameErrorCode;
import game.value.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차 위치 비교_성공")
    void comparePositionOfCar_ShouldBeTrue() {
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        car2.move(4);
        assertThat(car1.compareTo(car2) == 1).isTrue();
        car1.move(5);
        assertThat(car1.compareTo(car2) == 0).isTrue();
        car1.move(6);
        assertThat(car1.compareTo(car2) == -1).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 위치 이동_실패")
    @ValueSource(ints = {-1, 10})
    void isValidRangeOfMovingNumber_ShouldBe0to9_false(int movingNumber) {
        assertThatThrownBy(()->{
            new Car(new CarName("myCar")).move(movingNumber);
        }, "자동차 이름 길이는 1~5자만 허용한다.").isInstanceOf(IllegalArgumentException.class).hasMessage(GameErrorCode.INVALID_RANGE_OF_MOVING_NUMBER.getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 위치 계산_전진")
    @ValueSource(ints = {4,5,6,7,8,9})
    void isValidMovingForward_ShouldBe4to9_true(int movingNumber) {
        Car car = new Car(new CarName("myCar"));
        car.move(movingNumber);
        assertThat(car.getPosition() == 1).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 위치 계산_멈춤")
    @ValueSource(ints = {0,1,2,3})
    void isValidMovingStop_ShouldBe0to3_true(int movingNumber) {
        Car car = new Car(new CarName("myCar"));
        car.move(movingNumber);
        assertThat(car.getPosition() == 0).isTrue();
    }

    @Test
    @DisplayName("자동차 경기 상태 확인_전진")
    void checkStatusOfMovingCar_ShouldBeForward() {
        Car car = new Car(new CarName("myCar"));
        StringBuilder resultMessageBuilder = new StringBuilder();
        resultMessageBuilder.append(car.getCarName().getName() + ":");

        for(int i=4; i<=9; i++) {
            car.move(i);
            resultMessageBuilder.append("-");
            assertThat(car.toString()).isEqualTo(resultMessageBuilder.toString());
        }
    }

    @Test
    @DisplayName("자동차 경기 상태 확인_멈춤")
    void checkStatusOfMovingCar_ShouldBeStop() {
        Car car = new Car(new CarName("myCar"));
        StringBuilder resultMessageBuilder = new StringBuilder();
        resultMessageBuilder.append(car.getCarName().getName() + ":");

        for(int i=0; i<4 ; i++) {
            car.move(i);
            assertThat(car.toString()).isEqualTo(resultMessageBuilder.toString());
        }
    }
}

