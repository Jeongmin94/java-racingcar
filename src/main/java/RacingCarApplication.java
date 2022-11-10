import racing.input.InputView;
import racing.manager.RacingCarManager;
import racing.output.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarManager rm = new RacingCarManager(inputView.getCarCount());
        OutputView outputView = new OutputView(inputView.getCarCount(), inputView.getRaceCount());
        outputView.race(rm);
    }
}
