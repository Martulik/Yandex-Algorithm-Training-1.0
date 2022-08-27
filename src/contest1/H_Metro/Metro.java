package contest1.H_Metro;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Metro {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest1/H_Metro/input.txt"));
             PrintStream printStream = new PrintStream("src/contest1/H_Metro/output.txt")) {
            int a = scanner.nextInt();  // интервал между поездами на первом пути
            int b = scanner.nextInt();  // интервал между поездами на втором пути
            int n = scanner.nextInt();  // количество поездов на первом пути
            int m = scanner.nextInt();  // количество поездов на втором пути
            int max = Integer.min(n + a * (n + 1), m + b * (m + 1));
            int min = Integer.max(n + a * (n - 1), m + b * (m - 1));
            printStream.print(min > max ? -1 : min + " " + max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
