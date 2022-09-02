package contest3.B_IntersectionSets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class IntersectionSets {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/contest3/B_IntersectionSets/input.txt"));
             PrintStream ps = new PrintStream("src/contest3/B_IntersectionSets/output.txt")) {
            check();
            getIntersectionSets(readList(br), readList(br)).forEach(x -> ps.print(x + " "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static List<Integer> readList(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static TreeSet<Integer> getIntersectionSets(List<Integer> list1, List<Integer> list2) {
        TreeSet<Integer> set = new TreeSet<>(list1);
        set.retainAll(new TreeSet<>(list2));
        return set;
    }

    private static void check() {
        assert getIntersectionSets(List.of(1, 3, 2), List.of(4, 3, 2)).equals(new TreeSet<>(List.of(2, 3)));
        assert getIntersectionSets(List.of(1, 2, 6, 4, 5, 7), List.of(10, 2, 3, 4, 8)).equals(new TreeSet<>(List.of(2, 4)));
    }
}
