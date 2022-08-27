package contest1.B_Triangle;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Triangle {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest1/B_Triangle/input.txt"));
             PrintStream printStream = new PrintStream("src/contest1/B_Triangle/output.txt")) {
            List<Integer> sides = new ArrayList<>(3);
            while (scanner.hasNext()) {
                sides.add(scanner.nextInt());
            }
            if (sides.stream().allMatch(x -> x > 0) && (sides.get(0) + sides.get(1) > sides.get(2) &&
                    sides.get(1) + sides.get(2) > sides.get(0) &&
                    sides.get(0) + sides.get(2) > sides.get(1))) {
                printStream.print("YES");
            } else {
                printStream.print("NO");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
