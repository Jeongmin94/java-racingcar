package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomUtilsTest {
    @DisplayName("0 ~ 10 사이의 임의의 정수 생성 테스트")
    @Test
    void makeRandomIntegerTest() {
        int randInt = RandomUtils.getRandomInteger();
        assertThat(randInt).isBetween(0, 10);
    }
}