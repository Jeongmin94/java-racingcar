import java.util.Scanner;

public class RacingCarApplication {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("자동차 대수는 몇 대 인가요?:");
            String racingCars = scanner.nextLine();
            System.out.println("racingCars: " + racingCars);

            System.out.println("시도할 횟수는 몇 회 인가요?:");
            String tryCount = scanner.nextLine();
            System.out.println("tryCount: " + tryCount);

            // 실행결과 출력
            System.out.println("실행 결과");
        }
    }
}
