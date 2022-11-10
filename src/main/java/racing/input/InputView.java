package racing.input;

import racing.manager.RacingCarManager;
import racing.output.OutputView;
import utils.ParseUtils;

import java.util.Scanner;

public class InputView {

    private final int carCount;
    private final int raceCount;

    public InputView() {
        try (Scanner scanner = new Scanner(System.in)) {
            this.carCount = ParseUtils.parseInt(inputCarCount(scanner));
            this.raceCount = ParseUtils.parseInt(inputRaceCount(scanner));
        }
    }

    private String inputCarCount(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?:");
        String carCount = scanner.nextLine();
        System.out.println("racingCars: " + carCount);
        return carCount;
    }

    private String inputRaceCount(Scanner scanner) {
        System.out.println("시도할 횟수는 몇 회 인가요?:");
        String raceCount = scanner.nextLine();
        System.out.println("raceCount: " + raceCount);
        return raceCount;
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
