package racing;

import racing.output.RacingCarOutputView;

public class RacingCar {

    private final int id;
    private int position;
    private final RacingCarOutputView outputView;

    public RacingCar(int id) {
        this.id = id;
        this.position = 0;
        this.outputView = new RacingCarOutputView();
    }

    public void forward() {
        position++;
    }

    public void printMoveMark() {
        outputView.printRacingCarMove(id, position);
    }
}
