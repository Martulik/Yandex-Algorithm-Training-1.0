package contest1.C_PhoneNumber;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PhoneNumber {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest1/C_PhoneNumber/input.txt"));
             PrintStream printStream = new PrintStream("src/contest1/C_PhoneNumber/output.txt")) {
            String newNumberStr = scanner.next();
            String newNumber = getNumberWithoutCode(getOnlyDigits(newNumberStr));
            for (int i = 0; i < 3; ++i) {
                String number = scanner.next();
                number = getOnlyDigits(number);
                String numberWithout = getNumberWithoutCode(number);
                if (numberWithout.equals(newNumber)) {
                    printStream.println("YES");
                } else {
                    printStream.println("NO");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getOnlyDigits(String str) {
        return str.chars()
                .filter(Character::isDigit)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.joining());
    }

    private static String getNumberWithoutCode(String number) {
        String standCode = "495";
        StringBuilder stringBuilder = new StringBuilder(number);
        if ((stringBuilder.length() != 7 && stringBuilder.length() != 10) &&
                (number.startsWith("7") || number.startsWith("8"))) {
            stringBuilder.deleteCharAt(0);
        }
        if (stringBuilder.length() == 10 && stringBuilder.toString().startsWith(standCode)) {
            stringBuilder.delete(0, 3);
        }
        return String.valueOf(stringBuilder);
    }
}
