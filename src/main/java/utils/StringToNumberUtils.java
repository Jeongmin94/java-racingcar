package utils;

public class StringToNumberUtils {

    private StringToNumberUtils() {}

    public static int parseInt(String number) {
        int parseNum;
        try {
            parseNum = Integer.parseInt(number);
        } catch (RuntimeException e) {
            throw new RuntimeException(String.format("정수 변환 오류. %s는 정수가 아닙니다.", number));
        }
        return parseNum;
    }
}
