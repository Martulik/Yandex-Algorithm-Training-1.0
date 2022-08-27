package contest1.D_EquationWithRoot;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class EquationWithRoot {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest1/D_EquationWithRoot/input.txt"));
             PrintStream printStream = new PrintStream("src/contest1/D_EquationWithRoot/output.txt")) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (c < 0) {
                printStream.print("NO SOLUTION");
            } else if (a == 0) {
                if (b >= 0 && b == c * c) {
                    printStream.print("MANY SOLUTIONS");
                } else {
                    printStream.print("NO SOLUTION");
                }
            } else {
                double x = (double) (-b + c * c) / a;
                if (x % 1 != 0) {
                    printStream.print("NO SOLUTION");
                } else {
                    printStream.print((int) x);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
