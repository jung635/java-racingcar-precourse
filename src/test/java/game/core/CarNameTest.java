package game.core;

import common.code.GameErrorCode;
import game.value.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarNameTest {

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 확인_실패")
    @ValueSource(strings = {"", "abcdef"})
    void isValidNameOfCarLength_ShouldBe1to5_false(String inputCarName) {
        assertThatThrownBy(()->{
            new CarName(inputCarName);
        }, "자동차 이름 길이는 1~5자만 허용한다.").isInstanceOf(IllegalArgumentException.class).hasMessage(GameErrorCode.INVALID_LENGTH_OF_CAR_NAME.getErrorMessage());
    }

    @ParameterizedTest
    @DisplayName("자동차 이름 입력 확인_성공")
    @ValueSource(strings = {"a", "abc", "abcde"})
    void isValidNameOfCarLength_ShouldBe1to5_true(String inputCarName) {
        String carName = new CarName(inputCarName).getName();
        assertThat(carName.length() > 0 && carName.length() < 6).isTrue();
    }
}
