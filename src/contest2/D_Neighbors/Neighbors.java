package contest2.D_Neighbors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

public class Neighbors {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("src/contest2/D_Neighbors/input.txt"));
                PrintStream ps = new PrintStream("src/contest2/D_Neighbors/output.txt")) {
            String str = br.readLine();
            if (str.isEmpty()) {
                ps.print(0);
            } else {
                int[] nums = Arrays.stream(str.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                ps.print(countElemLargerNeighbors(nums));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countElemLargerNeighbors(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length - 1; ++i) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                ++count;
            }
        }
        return count;
    }
}

