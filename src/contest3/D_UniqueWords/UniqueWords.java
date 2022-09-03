package contest3.D_UniqueWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UniqueWords {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/contest3/D_UniqueWords/input.txt"));
             PrintStream ps = new PrintStream("src/contest3/D_UniqueWords/output.txt")) {
            Set<String> set = new HashSet<>();
            String str;
            while ((str = br.readLine()) != null && !str.isEmpty()) {
                String[] words = str.trim().split("\\s+");
                set.addAll(Arrays.asList(words));
            }

            ps.print(set.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
