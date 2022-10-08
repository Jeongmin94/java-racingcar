package racing.car;

import racing.output.RacingCarOutputView;
import utils.RandomUtils;

public class RacingCar {

    private static final int STANDARD_FOR_MOVE = 4;

    private final int id;
    private int position;

    public RacingCar(int id) {
        this.id = id;
        this.position = 0;
    }

    private void movePositionForward() {
        position++;
    }

    private void printMoveMark() {
        RacingCarOutputView.printRacingCarMove(id, position);
    }

    public void forward(int randomInt) {
        if (randomInt >= RandomUtils.MAX_RANDOM_VALUE || randomInt < 0) {
            throw new IllegalArgumentException(String.format("randomInt의 범위가 지정한 범위(0 ~ 9)를 초과했습니다. randomInt: %d, max: %d", randomInt, RandomUtils.MAX_RANDOM_VALUE));
        }
        if (randomInt >= STANDARD_FOR_MOVE) {
            this.movePositionForward();
        }
        this.printMoveMark();
    }
}
