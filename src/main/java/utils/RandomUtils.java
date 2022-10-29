package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    private static final Random random = new Random();
    public static final int MAX_RANDOM_VALUE = 10;

    private RandomUtils() {

    }

    public static int getRandomInteger() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }

    public static List<Integer> getRandomIntegerList(int size) {
        List<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            randoms.add(getRandomInteger());
        }
        return randoms;
    }
}
