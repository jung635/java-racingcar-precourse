package game.core;

import common.code.GameErrorCode;
import game.value.CarList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarListTest {

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 테스트_Exception")
    @ValueSource(strings = {""})
    void isEmptyCarNameInput_ShouldBeThrowException(String carNameInput) {
        assertThatThrownBy(()->{
            new CarList(carNameInput);
        }, "자동차 이름은 '' 일 수 없다..").isInstanceOf(IllegalArgumentException.class).hasMessage(GameErrorCode.EMPTY_CAR_NAME.getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 테스트_Exception")
    @ValueSource(strings = {"," ,",,", "car1,car2,", ",car1,car2"})
    void isValidCarNameInput_ShouldBeThrowException(String carNameInput) {
        assertThatThrownBy(()->{
            new CarList(carNameInput);
        }, "자동차 이름이 ,로 시작하거나 끝날 수 없다.").isInstanceOf(IllegalArgumentException.class).hasMessage(GameErrorCode.INVALID_CAR_INPUT_FORMAT.getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 대 수 테스트_Exception")
    @ValueSource(strings = {"car"})
    void isValidNumberOfCars_ShouldBeThrowException(String carNameInput) {
        assertThatThrownBy(()->{
            new CarList(carNameInput);
        }, "자동차는 적어도 2대 이상이어야 한다.").isInstanceOf(IllegalArgumentException.class).hasMessage(GameErrorCode.INSUFFICIENT_NUMBER_OF_CAR.getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 중복 테스트_Exception")
    @ValueSource(strings = {"car,car"})
    void isDuplicatedCarNameInput_ShouldBeThrowException(String carNameInput) {
        assertThatThrownBy(()->{
            new CarList(carNameInput);
        }, "자동차 이름은 중복 될 수 없다.").isInstanceOf(IllegalArgumentException.class).hasMessage(GameErrorCode.DUPLICATED_CAR_NAME.getErrorMessage());
    }


    @ParameterizedTest
    @DisplayName("자동차 이름 입력 테스트_성공")
    @ValueSource(strings = {"car1,car2"})
    void isValidCarNameInput_ShouldBeThrowTrue(String carNameInput) {
        CarList carList =  new CarList(carNameInput);
        assertThat(carList.getCarList().size() == 2).isTrue();
    }
}