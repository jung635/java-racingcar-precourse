package game.core;

import game.core.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 확인_성공")
    @ValueSource(strings = {"a", "abc", "abcde"})
    void isValidNameOfCarLength_ShouldBe1to5_true(String inputCarName) {
        String carName = new Cars(inputCarName).getName();
        assertThat(carName.length() > 0 && carName.length() < 6).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 확인_실패")
    @ValueSource(strings = {"", "abcdef"})
    void isValidNameOfCarLength_ShouldBe1to5_false(String inputCarName) {
        assertThatThrownBy(()->{
            new Cars(inputCarName);
        }, "자동차 이름 길이는 1~5자만 허용한다.").isInstanceOf(RuntimeException.class).hasMessage("Length of name of car should be from 1 to 5.");
    }

    @ParameterizedTest
    @DisplayName("자동차 위치 입력_성공")
    @ValueSource(ints = {0,1,2,3,4,5,6,7,8,9})
    void isValidInputPostionOfCarRange_ShouldBe0to9_true(int inputPosition) {
        Cars car = new Cars("myCar");
        car.move(inputPosition);
        assertThat(car.getPosition() >= 0 && car.getPosition() < 10).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 위치 입력_실패")
    @ValueSource(ints = {-1,10})
    void isValidInputPostionOfCarRange_ShouldBe0to9_false(int inputPosition) {
        assertThatThrownBy(()->{
            new Cars("myCar").move(inputPosition);
        }, "자동차 위치 입력 길이는 1~5자만 허용한다.").isInstanceOf(RuntimeException.class).hasMessage("Input of position of car should be from 0 to 9.");
    }

    @ParameterizedTest
    @DisplayName("자동차 위치 계산_전진")
    @ValueSource(ints = {4,5,6,7,8,9})
    void isValidMovingForward_ShouldBe4to9_true(int inputPosition) {
        Cars car = new Cars("myCar");
        car.move(inputPosition);
        assertThat(car.getPosition() == (inputPosition)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("자동차 위치 계산_멈춤")
    @ValueSource(ints = {0,1,2,3})
    void isValidMovingStop_ShouldBe0to3_true(int inputPosition) {
        Cars car = new Cars("myCar");
        car.move(inputPosition);
        assertThat(car.getPosition() == 0).isTrue();
    }
}

