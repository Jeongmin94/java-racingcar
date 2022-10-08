package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarTest {

    private static final int TEST_ID = 1;

    @DisplayName("0 ~ 9 범위를 초과하는 랜덤값이 입력됐을 때 예외 테스트")
    @Test
    void forwardIllegalValueTest() {
        RacingCar racingCar = new RacingCar(TEST_ID);
        int illegalValue = 100;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> racingCar.forward(illegalValue))
                .withMessageContaining("지정한 범위를 초과");
    }
}