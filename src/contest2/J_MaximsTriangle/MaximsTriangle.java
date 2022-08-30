package contest2.J_MaximsTriangle;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class MaximsTriangle {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest2/J_MaximsTriangle/input.txt"));
             PrintStream ps = new PrintStream("src/contest2/J_MaximsTriangle/output.txt")) {
            short nNotes = scanner.nextShort();
            double prev = scanner.nextDouble();
            double left = 30;
            double right = 4000;
            for (int i = 0; i < nNotes - 1; ++i) {
                double current = scanner.nextDouble();
                String str = scanner.next();
                double border = Math.abs(prev + current) / 2;
                if ((str.equals("closer") && current < prev) || (str.equals("further") && current > prev)) {
                    right = Double.min(right, border);
                } else {
                    left = Double.max(left, border);
                }
                prev = current;
            }
            ps.print(left + " " + right);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}