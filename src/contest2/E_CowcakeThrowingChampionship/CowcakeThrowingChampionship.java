package contest2.E_CowcakeThrowingChampionship;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CowcakeThrowingChampionship {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest2/E_CowcakeThrowingChampionship/input.txt"));
             PrintStream ps = new PrintStream("src/contest2/E_CowcakeThrowingChampionship/output.txt")) {
            short[] nums = new short[scanner.nextInt()];
            int winnerIndex = 0;
            int vasyaIndex = 0;
            nums[0] = scanner.nextShort();
            for (int i = 1; i < nums.length; ++i) {
                nums[i] = scanner.nextShort();
                if (nums[i] > nums[winnerIndex]) {
                    winnerIndex = i;
                } else if (nums[i - 1] > nums[i] && nums[i - 1] % 10 == 5 && winnerIndex < i) {
                    if (vasyaIndex <= winnerIndex || nums[i - 1] > nums[vasyaIndex]) {
                        vasyaIndex = i - 1;
                    }
                }
            }
            ps.print(winnerIndex >= vasyaIndex ? 0 : countStrictlyMoreX(nums, vasyaIndex) + 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countStrictlyMoreX(short[] nums, int x) {
        int count = 0;
        for (short num : nums) {
            if (num > nums[x]) {
                ++count;
            }
        }
        return count;
    }

}
