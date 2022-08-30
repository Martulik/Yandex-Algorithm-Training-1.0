package contest2.G_ProductTwoNumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

public class ProductTwoNumbers {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/contest2/G_ProductTwoNumbers/input.txt"));
             PrintStream printStream = new PrintStream("src/contest2/G_ProductTwoNumbers/output.txt")
        ) {
            check();
            int[] maxProduct = maxProduct(Arrays.stream(br.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray());
            printStream.print(maxProduct[0] + " " + maxProduct[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[] maxProduct(int[] nums) {
        int maxPositiveNum = -1;
        int secondMaxPositiveNum = -1;
        int maxNegativeNum = 1;
        int secondMaxNegativeNum = 1;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < 0) {
                if (nums[i] < maxNegativeNum) {
                    secondMaxNegativeNum = maxNegativeNum;
                    maxNegativeNum = nums[i];
                } else if (nums[i] < secondMaxNegativeNum) {
                    secondMaxNegativeNum = nums[i];
                }
            } else {
                if (nums[i] > maxPositiveNum) {
                    secondMaxPositiveNum = maxPositiveNum;
                    maxPositiveNum = nums[i];
                } else if (nums[i] > secondMaxPositiveNum) {
                    secondMaxPositiveNum = nums[i];
                }
            }
        }
        if (secondMaxPositiveNum == -1 && secondMaxNegativeNum == 1) {
            return new int[]{maxNegativeNum, maxPositiveNum};
        } else if (maxNegativeNum == 1) {
            return new int[]{secondMaxPositiveNum, maxPositiveNum};
        } else if (maxPositiveNum == -1) {
            return new int[]{maxNegativeNum, secondMaxNegativeNum};
        } else {
            if ((long) maxPositiveNum * secondMaxPositiveNum > (long) maxNegativeNum * secondMaxNegativeNum) {
                return new int[]{secondMaxPositiveNum, maxPositiveNum};
            } else {
                return new int[]{maxNegativeNum, secondMaxNegativeNum};
            }
        }
    }

    public static void check() {
        assert Arrays.equals(maxProduct(new int[]{4, 3, 5, 2, 5}), new int[]{5, 5});
        assert Arrays.equals(maxProduct(new int[]{-4, 3, -5, 2, 5}), new int[]{-5, -4});
        assert Arrays.equals(maxProduct(new int[]{-100, 100}), new int[]{-100, 100});
        assert Arrays.equals(maxProduct(new int[]{-100, 1, 1}), new int[]{1, 1});
        assert Arrays.equals(maxProduct(new int[]{4, 3, -5, 2, 5}), new int[]{4, 5});
    }
}
