import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberTest {

    @Test
    @DisplayName("랜덤 숫자 범위 확인")
    void isValidRange_ShouldBe0To10() {
        assertThat(RandomNumber.generateRandomNumber() >= 0 && RandomNumber.generateRandomNumber() < 10).isTrue();
    }
}
