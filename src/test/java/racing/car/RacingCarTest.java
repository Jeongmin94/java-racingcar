package racing.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.exception.RandomIntegerOutOfRangeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingCarTest {

    @DisplayName("RacingCar 인스턴스 생성 테스트")
    @Test
    void constructorTest() {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.getPosition()).isZero();
    }

    @DisplayName("0 ~ 9 범위를 초과하는 랜덤값이 입력됐을 때 예외 테스트")
    @Test
    void moveForwardIllegalValueTest() {
        RacingCar racingCar = new RacingCar();
        int illegalValue = 100;
        assertThatExceptionOfType(RandomIntegerOutOfRangeException.class)
                .isThrownBy(() -> racingCar.moveForward(illegalValue))
                .withMessageContaining("지정한 범위(0 ~ 9)를 초과했습니다. randomInt: %d", illegalValue);
    }

    @DisplayName("4 미만의 정수가 입력됐을 때 RacingCar의 움직임 테스트(position이 0임)")
    @Test
    void moveForwardWhenUnder4Test() {
        RacingCar racingCar = new RacingCar();
        int randomInt = 3;
        racingCar.moveForward(randomInt);
        assertThat(racingCar.getPosition()).isZero();
    }
    
    @DisplayName("4 이상의 정수가 입력됐을 때 RacingCar의 움직임 테스트(position이 0이 아니어야함)")
    @Test
    void moveForwardWhenUp4Test() {
        RacingCar racingCar = new RacingCar();
        int randomInt = 4;
        racingCar.moveForward(randomInt);
        assertThat(racingCar.getPosition()).isNotZero();
    }
}