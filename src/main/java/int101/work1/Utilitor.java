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

    public static long computeIsbn10(long value) {
        String cleanedISBN = String.valueOf(value);

        // Check if the ISBN has exactly 10 digits
        if (cleanedISBN.length() != 10) {
            throw new IllegalArgumentException("Invalid ISBN: must contain exactly 10 digits");
        }

        // Calculate the sum
        int sum = 0;
        for (int i = 10; i > 1; i--) {
            int digit = cleanedISBN.charAt(10 - i) - '0';
            sum += (i ) * digit;
            //System.out.println("i: " + i + "| digit= " + digit + " | value= " + (i * digit));
        }

        //System.out.println("Sum: " + sum);

        int checkDigit = 11 - (sum % 11);

        System.out.println("checkDigit: " + checkDigit);
        // Return the ISBN as a long integer
        //System.out.println("Length: " + cleanedISBN.length());
        long toReturn = Long.parseLong(cleanedISBN.substring(0, 9) + checkDigit);

        //System.out.println(isIsBn10(toReturn) ? "Hell yea" : "Naj");
        return toReturn;

    }

    public static boolean isIsBn10(long value) {
        String cleanedISBN = String.valueOf(value);
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int digit = cleanedISBN.charAt(i) - '0';
            sum += (i + 1) * digit;
        }

        return sum % 11 == 0;
    }
}
