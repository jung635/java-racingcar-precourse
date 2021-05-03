package game.core;

import common.code.GameErrorCode;
import game.value.TryCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class TryCountTest {

    @ParameterizedTest
    @DisplayName("시도 횟수 입력 확인_성공")
    @ValueSource(ints = {1,2})
    void isValidTryCount_ShouldBeFrom1To5_Success(int tryCount) {
        new TryCount(tryCount);
    }

    @ParameterizedTest
    @DisplayName("시도 횟수 입력 확인_실패")
    @ValueSource(ints = {-1,0})
    void isValidTryCount_ShouldBeFrom1To5_Fail(int tryCount) {
        assertThatThrownBy(() -> {
            new TryCount(tryCount);
        },"게임 시도 횟수는 양수만 허용된다. ").isInstanceOf(IllegalArgumentException.class).hasMessage(GameErrorCode.INVALID_RANGE_OF_TRY_COUNT.getErrorMessage());
    }
}
