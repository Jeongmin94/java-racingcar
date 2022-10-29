package racing.exception;

import utils.RandomUtils;

public class RandomIntegerOutOfRangeException extends RuntimeException {

    public static boolean validateRandomInteger(int random) {
        return (random < RandomUtils.MAX_RANDOM_VALUE) && (random >= 0);
    }

    public RandomIntegerOutOfRangeException(String message) {
        super(message);
    }
}
