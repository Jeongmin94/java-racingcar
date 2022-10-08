package utils;

import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();
    public static final int MAX_RANDOM_VALUE = 10;

    private RandomUtils() {

    }

    public static int getRandomInteger() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }
}
