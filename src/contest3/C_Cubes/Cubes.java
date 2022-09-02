package contest3.C_Cubes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cubes {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/contest3/C_Cubes/input.txt"));
             PrintStream ps = new PrintStream("src/contest3/C_Cubes/output.txt")) {
            int[] nCubes = Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            List<Integer> list1 = readList(br, nCubes[0]);
            List<Integer> list2 = readList(br, nCubes[1]);
            List<Integer> list3 = list1.stream().filter(list2::contains).sorted().collect(Collectors.toList());
            printList(list3, ps);
            printList(getOtherCubes(list1, list3), ps);
            printList(getOtherCubes(list2, list3), ps);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readList(BufferedReader br, int size) throws IOException {
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            list.add(readInt(br));
        }
        return list;
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static void printList(List<Integer> list, PrintStream ps) {
        ps.println(list.size());
        for (Integer i : list) {
            ps.print(i + " ");
        }
        ps.println();
    }

    private static List<Integer> getOtherCubes(List<Integer> listWithAllCubes, List<Integer> listCubesToFilter) {
        return listWithAllCubes.stream()
                .filter(x -> !listCubesToFilter.contains(x))
                .sorted()
                .collect(Collectors.toList());
    }
}
