package game.core;

import game.core.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {

    @Test
    @DisplayName("랜덤 숫자 범위 확인")
    void isValidRange_ShouldBe0To9() {
        assertThat(RandomNumber.generateRandomNumber() >= 0 && RandomNumber.generateRandomNumber() <= 9).isTrue();
    }
}
