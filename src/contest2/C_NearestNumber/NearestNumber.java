package contest2.C_NearestNumber;


import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeSet;

public class NearestNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest2/C_NearestNumber/input.txt"));
             PrintStream ps = new PrintStream("src/contest2/C_NearestNumber/output.txt")) {
            short n = scanner.nextShort();
            TreeSet<Short> treeSet = new TreeSet<>();
            for (int i = 0; i < n; ++i) {
                treeSet.add(scanner.nextShort());
            }
            short target = scanner.nextShort();
            ps.print(getNearestNumber(treeSet, target));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static short getNearestNumber(TreeSet<Short> treeSet, short target) {
        if (treeSet.last() < target) {
            return treeSet.last();
        }
        if (treeSet.first() > target) {
            return treeSet.first();
        }
        short max = treeSet.ceiling(target);
        short min = treeSet.floor(target);
        return target - min > max - target ? max : min;
    }
}
