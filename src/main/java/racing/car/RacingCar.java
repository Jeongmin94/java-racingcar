package racing.car;

import racing.exception.RandomIntegerOutOfRangeException;
import utils.StringUtils;

public class RacingCar {

    private static final int STANDARD_FOR_MOVE = 4;

    private int position;

    public RacingCar() {
        this.position = 0;
    }

    public void moveForward(int randomInt) {
        if (!RandomIntegerOutOfRangeException.validateRandomInteger(randomInt)) {
            throw new RandomIntegerOutOfRangeException(StringUtils.getInvalidRandomIntMessage(randomInt));
        }
        if (randomInt >= STANDARD_FOR_MOVE) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
