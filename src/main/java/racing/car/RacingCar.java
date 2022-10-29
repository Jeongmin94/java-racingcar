package racing.car;

import racing.exception.RandomIntegerOutOfRangeException;
import utils.StringUtils;

public class RacingCar {

    private static final int STANDARD_FOR_MOVE = 4;

    private final int id;
    private int position;

    public RacingCar(int id) {
        this.id = id;
        this.position = 0;
    }

    private void movePosition() {
        position++;
    }

    public void moveForward(int randomInt) {
        if (!RandomIntegerOutOfRangeException.validateRandomInteger(randomInt)) {
            throw new RandomIntegerOutOfRangeException(StringUtils.getInvalidRandomIntMessage(randomInt));
        }
        if (randomInt >= STANDARD_FOR_MOVE) {
            this.movePosition();
        }
    }

    public int getPosition() {
        return position;
    }
}
