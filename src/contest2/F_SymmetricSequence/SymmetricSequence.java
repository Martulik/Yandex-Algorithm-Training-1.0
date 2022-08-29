package contest2.F_SymmetricSequence;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class SymmetricSequence {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest2/F_SymmetricSequence/input.txt"));
             PrintStream ps = new PrintStream("src/contest2/F_SymmetricSequence/output.txt")) {
            byte n = scanner.nextByte();
            byte[] nums = new byte[n];
            for (byte i = 0; i < n; ++i) {
                nums[i] = scanner.nextByte();
            }

            byte count = countAdditionSize(nums);
            ps.println(count);
            for (byte i = (byte) (count - 1); i >= 0; --i) {
                ps.print(nums[i] + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte countAdditionSize(byte[] nums) {
        for (byte i = 0; i < nums.length - 1; ++i) {
            byte left = i;
            byte right = (byte) (nums.length - 1);
            while (nums[left] == nums[right] && right >= left) {
                ++left;
                --right;
            }
            if (left > right) {
                return i;
            }
        }
        return (byte) (nums.length - 1);
    }
}
