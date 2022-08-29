package contest2.B_SequenceType;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class SequenceType {

    public static void main(String[] args) {
        final int endOfSeq = (int) (-2 * Math.pow(10, 9));
        try (Scanner scanner = new Scanner(new File("src/contest2/B_SequenceType/input.txt"));
             PrintStream ps = new PrintStream("src/contest2/B_SequenceType/output.txt")) {
            int prev = scanner.nextInt();
            String currentType = "";
            while (scanner.hasNext() && !currentType.equals("RANDOM")) {
                int current = scanner.nextInt();
                if (current == endOfSeq) {
                    break;
                }
                currentType = getCurrentType(prev, current, currentType);
                prev = current;
            }
            if (currentType.isEmpty() && prev != endOfSeq) {
                currentType = "CONSTANT";
            }
            ps.print(currentType);
            System.out.println(currentType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isWeaklyAscending(int prev, int current) {
        return prev == current || prev < current;
    }

    public static boolean isAscending(int prev, int current) {
        return prev < current;
    }

    public static boolean isWeaklyDescending(int prev, int current) {
        return prev == current || prev > current;
    }

    public static boolean isDescending(int prev, int current) {
        return prev > current;
    }

    public static String getCurrentType(int prev, int current, String currentType) {
        if (currentType.isEmpty()) {
            if (prev == current) {
                return "CONSTANT";
            }
            return prev > current ? "DESCENDING" : "ASCENDING";
        }
        if (currentType.equals("CONSTANT")) {
            if (prev == current) {
                return currentType;
            }
            return prev > current ? "WEAKLY DESCENDING" : "WEAKLY ASCENDING";
        }
        if (currentType.equals("WEAKLY ASCENDING")) {
            return isWeaklyAscending(prev, current) ? currentType : "RANDOM";
        }
        if (currentType.equals("ASCENDING")) {
            if (isAscending(prev, current)) {
                return currentType;
            }
            return prev == current ? "WEAKLY ASCENDING" : "RANDOM";
        }
        if (currentType.equals("DESCENDING")) {
            if (isDescending(prev, current)) {
                return currentType;
            }
            return prev == current ? "WEAKLY DESCENDING" : "RANDOM";
        }
        if (currentType.equals("WEAKLY DESCENDING")) {
            return isWeaklyDescending(prev, current) ? currentType : "RANDOM";
        }
        return "RANDOM";
    }

}
