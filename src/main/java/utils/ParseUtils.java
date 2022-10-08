package utils;

public class ParseUtils {

    private ParseUtils() {
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(String.format("number는 정수가 아닙니다. number: %s", number));
        }
    }
}
