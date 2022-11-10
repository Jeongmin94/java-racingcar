import racing.input.InputView;
import racing.manager.RacingCarManager;
import racing.manager.RacingManager;
import racing.output.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        RacingCarManager rcm = new RacingCarManager(inputView.getCarCount());
        RacingManager rm = new RacingManager(inputView.getRaceCount());

        OutputView outputView = new OutputView();
        outputView.initRace();
        while (rm.race()) {
            rcm.forward();
            outputView.race(rcm.getRacingCars());
            rm.decreaseRaceCount();
        }
    }
}
