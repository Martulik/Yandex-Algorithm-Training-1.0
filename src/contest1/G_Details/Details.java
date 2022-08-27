package contest1.G_Details;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Details {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest1/G_Details/input.txt"));
             PrintStream printStream = new PrintStream("src/contest1/G_Details/output.txt")) {
            int n = scanner.nextInt();                   // кг сплава
            int k = scanner.nextInt();                   // кг заготовка
            int m = scanner.nextInt();                   // кг делали
            int nM = 0;                                  // штук деталей
            while (n >= k && k >= m) {
                int nK = n / k;                          // количество заготовок, каждая по k кг
                int remainsK = n % k;                    // лишнее от заготовок
                nM += (k / m) * nK;
                int remainsM = (k % m) * nK;             // лишнее от деталей
                n = remainsK + remainsM;                 // лишнее от всего
            }
            printStream.print(nM);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
