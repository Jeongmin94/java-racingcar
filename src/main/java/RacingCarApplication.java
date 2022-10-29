import racing.input.InputView;
import racing.manager.RacingCarManager;
import racing.output.OutputView;

public class RacingCarApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        RacingCarManager rm = inputView.getRacingCarManager();
        OutputView outputView = inputView.getOutputView();
        outputView.race(rm);
    }
}
