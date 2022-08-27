package contest1.I_Prisoner;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Prisoner {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest1/I_Prisoner/input.txt"));
             PrintStream printStream = new PrintStream("src/contest1/I_Prisoner/output.txt")) {
            int[] brick = new int[3];
            for (int i = 0; i < brick.length; ++i) {
                brick[i] = scanner.nextInt();
            }
            Arrays.sort(brick);
            int d = scanner.nextInt();
            int e = scanner.nextInt();
            if (Integer.min(d, e) >= brick[0] && Integer.max(d, e) >= brick[1]) {
                printStream.print("YES");
            } else {
                printStream.print("NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
