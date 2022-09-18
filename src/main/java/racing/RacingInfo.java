package racing;

import java.util.Scanner;

public class RacingInfo {
    private final int carCount;
    private final int raceCount;

    public RacingInfo(String carCount, String raceCount) {
        try {
            this.carCount = Integer.parseInt(carCount);
            this.raceCount = Integer.parseInt(raceCount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("carCount와 raceCount는 정수여야 합니다. carCount: %s, raceCount: %s", carCount, raceCount));
        }
    }

    public static RacingInfo userInputToRacingInfo() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("자동차 대수는 몇 대 인가요?:");
            String carCount = scanner.nextLine();
            System.out.println("racingCars: " + carCount);

            System.out.println("시도할 횟수는 몇 회 인가요?:");
            String raceCount = scanner.nextLine();
            System.out.println("raceCount: " + raceCount);

            return new RacingInfo(carCount, raceCount);
        }
    }

    public int getCarCount() {
        return carCount;
    }

    public int getRaceCount() {
        return raceCount;
    }
}
