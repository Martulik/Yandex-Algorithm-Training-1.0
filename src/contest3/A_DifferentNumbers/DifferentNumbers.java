package contest3.A_DifferentNumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DifferentNumbers {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/contest3/A_DifferentNumbers/input.txt"));
             PrintStream ps = new PrintStream("src/contest3/A_DifferentNumbers/output.txt")) {
            Set<String> setOfString = new HashSet<>(Arrays.asList(br.readLine().split("\\s")));
            ps.print(setOfString.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
