package int101.work1;

public class Utilitor {

    public static String testString(String value) {
        if(value == null) throw new NullPointerException("The input string is null");
        if(value.isBlank()) throw new IllegalArgumentException("The input string is blank");

        return value;
    }

    public static double testPositive(double value) {
        if(value <= 0) throw new IllegalArgumentException("The input must be positive");

        return value;
    }

    public static long computeIsbn10(long isbn10) {
        if(isbn10 < 0) throw new IllegalArgumentException("The input must greater than 0.");
        String numAsString = String.valueOf(isbn10);

        //if(numAsString.length() != 9) throw new IllegalArgumentException("The input must have 9 digits.");

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = (numAsString.charAt(i) - '0');
            sum += (i + 1) * digit;
        }

        int checkDigit = sum % 11;

        numAsString += (checkDigit== 10 ? 11 - (sum % 11) : "0" + checkDigit);

        return Long.valueOf(numAsString);
    }




}
