package utils;

public class StringUtils {

    private StringUtils() {
    }

    public static String getInvalidRandomIntMessage(int random) {
        return String.format("randomInt의 범위가 지정한 범위(0 ~ 9)를 초과했습니다. randomInt: %d, max: %d", random, RandomUtils.MAX_RANDOM_VALUE);
    }
}
