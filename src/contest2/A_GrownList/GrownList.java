package contest2.A_GrownList;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class GrownList {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest2/A_GrownList/input.txt"));
             PrintStream ps = new PrintStream("src/contest2/A_GrownList/output.txt")) {
            int prev = Integer.MIN_VALUE;
            while (scanner.hasNext()) {
                int current = scanner.nextInt();
                if (current > prev) {
                    prev = current;
                } else {
                    ps.print("NO");
                    return;
                }
            }
            ps.print("YES");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
