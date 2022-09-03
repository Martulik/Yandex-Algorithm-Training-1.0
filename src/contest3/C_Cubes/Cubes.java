package contest3.C_Cubes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.TreeSet;

public class Cubes {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/contest3/C_Cubes/input.txt"));
             PrintStream ps = new PrintStream("src/contest3/C_Cubes/output.txt")) {
            int[] nCubes = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            TreeSet<Integer> set1 = readTreeSet(br, nCubes[0]);
            TreeSet<Integer> set2 = readTreeSet(br, nCubes[1]);

            TreeSet<Integer> intersection = (TreeSet<Integer>) set1.clone();
            intersection.retainAll(set2);
            printSet(intersection, ps);

            set1.removeAll(intersection);
            printSet(set1, ps);

            set2.removeAll(intersection);
            printSet(set2, ps);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static TreeSet<Integer> readTreeSet(BufferedReader br, int size) throws IOException {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < size; ++i) {
            set.add(readInt(br));
        }
        return set;
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static void printSet(TreeSet<Integer> set, PrintStream ps) {
        ps.println(set.size());
        String[] setAsArrayOfStrings = Arrays.stream(set.toArray()).map(String::valueOf).toArray(String[]::new);
        ps.println(String.join(" ", setAsArrayOfStrings));
    }

}
