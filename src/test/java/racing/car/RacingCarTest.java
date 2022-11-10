package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.RandomIntegerOutOfRangeException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarTest {

    @DisplayName("0 ~ 9 범위를 초과하는 랜덤값이 입력됐을 때 예외 테스트")
    @Test
    void forwardIllegalValueTest() {
        RacingCar racingCar = new RacingCar();
        int illegalValue = 100;
        assertThatExceptionOfType(RandomIntegerOutOfRangeException.class)
                .isThrownBy(() -> racingCar.moveForward(illegalValue))
                .withMessageContaining("지정한 범위(0 ~ 9)를 초과했습니다. randomInt: %d", illegalValue);
    }
}