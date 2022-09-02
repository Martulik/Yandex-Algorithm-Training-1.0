package contest2.E_CowcakeThrowingChampionship;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CowcakeThrowingChampionship {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest2/E_CowcakeThrowingChampionship/input.txt"));
             PrintStream ps = new PrintStream("src/contest2/E_CowcakeThrowingChampionship/output.txt")) {
            int n = scanner.nextInt();
            List<Short> nums = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                nums.add(scanner.nextShort());
            }
            check();
            ps.print(getVasyaPlace(nums));
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public static int countStrictlyMoreX(List<Short> nums, short x) {
        int count = 0;
        for (short num : nums) {
            if (num > x) {
                ++count;
            }
        }
        return count;
    }

    public static int getVasyaPlace(List<Short> nums) {
        short winner = nums.get(0);
        short vasyaThrow = -1;
        for (int i = 2; i < nums.size(); ++i) {
            if (nums.get(i - 1) > winner) {
                winner = nums.get(i - 1);
                vasyaThrow = -1;
            } else {
                if (nums.get(i - 1) % 10 == 5 && nums.get(i) < nums.get(i - 1) &&
                        (vasyaThrow == -1 || vasyaThrow < nums.get(i - 1))) {
                    vasyaThrow = nums.get(i - 1);
                }
            }
        }
        return vasyaThrow == -1 ? 0 : countStrictlyMoreX(nums, vasyaThrow) + 1;
    }

    public static void check() {
        assert getVasyaPlace(new ArrayList<>() {{
            addAll(List.of(new Short[]{10, 20, 15, 10, 30, 5, 1}));
        }}) == 6;
        assert getVasyaPlace(new ArrayList<>() {{
            addAll(List.of(new Short[]{15, 15, 10}));
        }}) == 1;
        assert getVasyaPlace(new ArrayList<>() {{
            addAll(List.of(new Short[]{10, 15, 20}));
        }}) == 0;

        assert getVasyaPlace(new ArrayList<>() {{
            addAll(List.of(new Short[]{725, 25, 103}));
        }}) == 0;
        assert getVasyaPlace(new ArrayList<>() {{
            addAll(List.of(new Short[]{555, 76, 661, 478, 889, 453, 555, 359, 601, 835}));
        }}) == 5;
        assert getVasyaPlace(new ArrayList<>() {{
            addAll(List.of(new Short[]{275, 5, 595, 35, 25, 5, 655, 305, 275, 115, 55, 445, 155, 145, 15, 5, 175, 65,
                    15, 335, 65, 5, 15, 5, 145, 25, 245, 85, 35, 15, 45, 85, 75, 565, 35, 235, 185, 175, 95, 165, 75,
                    455, 225, 205, 15, 5, 125, 95, 75, 65, 25, 15, 5, 35, 25, 15, 5, 235, 145, 5, 175, 95, 465, 145,
                    105, 25, 145, 35, 525, 385, 235, 175, 85, 15, 5, 185, 5, 385, 145, 125, 105, 55, 125, 15, 5, 625,
                    475, 285, 245, 155, 125, 974, 135, 95, 15, 5, 15, 75, 5, 65
            }));
        }}) == 40;
    }
}
