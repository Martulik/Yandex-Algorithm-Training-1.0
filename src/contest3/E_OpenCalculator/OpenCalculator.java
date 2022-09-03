package contest3.E_OpenCalculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class OpenCalculator {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/contest3/E_OpenCalculator/input.txt"));
             PrintStream ps = new PrintStream("src/contest3/E_OpenCalculator/output.txt")) {
            check();
            List<String> buttons = Arrays.asList(br.readLine().split("\\s+"));
            String number = br.readLine();
            ps.print(minCountButtonsToAdd(buttons, number));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static short minCountButtonsToAdd(List<String> buttons, String number) {
        return (short) number.replaceAll(buttons.get(0), "")
                .replaceAll(buttons.get(1), "")
                .replaceAll(buttons.get(2), "").chars().distinct().count();
    }

    private static void check() {
        assert minCountButtonsToAdd(Arrays.asList("1", "2", "3"), "1123") == 0;
        assert minCountButtonsToAdd(Arrays.asList("1", "2", "3"), "1001") == 1;
        assert minCountButtonsToAdd(Arrays.asList("5", "7", "3"), "123") == 2;
    }
}
