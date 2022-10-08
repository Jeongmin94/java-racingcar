package racing.information;

import utils.ParseUtils;

import java.util.Scanner;

public class RacingInfo {
    private final Information racingInfo;

    public RacingInfo(String carCount, String raceCount) {
        int participants = ParseUtils.parseInt(carCount);
        int rounds = ParseUtils.parseInt(raceCount);

        racingInfo = Information.of(participants, rounds);
    }

    public static RacingInfo userInputToRacingInfo() {
        try (Scanner scanner = new Scanner(System.in)) {
            return new RacingInfo(inputCarCount(scanner), inputRaceCount(scanner));
        }
    }

    public int getCarCount() {
        return racingInfo.getParticipants();
    }

    public int getRaceCount() {
        return racingInfo.getRounds();
    }

    private static String inputCarCount(Scanner scanner) {
        System.out.println("자동차 대수는 몇 대 인가요?:");
        String carCount = scanner.nextLine();
        System.out.println("racingCars: " + carCount);
        return carCount;
    }

    private static String inputRaceCount(Scanner scanner) {
        System.out.println("시도할 횟수는 몇 회 인가요?:");
        String raceCount = scanner.nextLine();
        System.out.println("raceCount: " + raceCount);
        return raceCount;
    }

    private boolean isEqualTo(Information information) {
        return racingInfo.equals(information);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        RacingInfo ri = (RacingInfo) obj;
        return ri.isEqualTo(racingInfo);
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        return PRIME * result + this.racingInfo.hashCode();
    }
}
