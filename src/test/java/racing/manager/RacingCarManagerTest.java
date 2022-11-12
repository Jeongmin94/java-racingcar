package racing.manager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarManagerTest {

    private static final int TEST_CAR_COUNT = 3;

    @DisplayName("RacingCar의 개수가 3개인 RacingCarManager 인스턴스 생성 테스트")
    @Test
    void racingCarManagerConstructorTest() {
        RacingCarManager rcm = new RacingCarManager(TEST_CAR_COUNT);
        assertThat(rcm).isEqualTo(new RacingCarManager(TEST_CAR_COUNT));
    }
}
