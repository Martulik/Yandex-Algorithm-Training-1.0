package contest1.E_Emergency;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Emergency {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest1/E_Emergency/input.txt"));
             PrintStream printStream = new PrintStream("src/contest1/E_Emergency/output.txt")) {
            int k1 = scanner.nextInt();     // номер квартиры 1
            int m = scanner.nextInt();      // кол-во этажей в доме
            int k2 = scanner.nextInt();     // номер квартиры 2
            int p2 = scanner.nextInt();     // подъезд 2
            int n2 = scanner.nextInt();     // этаж 2
            check();
            int[] result = emergency(k1, m, k2, p2, n2);
            printStream.print(result[0] + " " + result[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int divisionRoundingUp(float numerator, int denominator) {
        float x = numerator / denominator;
        if (x % 1 != 0) {
            ++x;
        }
        return (int) x;
    }

    public static int getMinApartOnFloor(int k, int floors) {
        return divisionRoundingUp((float) k, floors);
    }

    public static int getMaxApartOnFloor(int k, int floors) {
        if (floors == 1) {
            return k;
        }
        if (floors == 2) {
            return k - 1;
        }
        int max = getMinApartOnFloor(k, floors);
        while ((max + 1) * (floors - 1) < k && (max + 1) * floors >= k) {
            max++;
        }
        return max;
    }

    public static int getFloor(int k, int minApartOnFloor, int maxApartOnFloor, int m) {
        int minN = divisionRoundingUp((float) k, minApartOnFloor);
        return minN % m == divisionRoundingUp((float) k, maxApartOnFloor) % m ? minN : 0;
    }

    public static int getEntrance(int k, int minApartOnFloor, int maxApartOnFloor, int m) {
        int minP = divisionRoundingUp(((float) k / minApartOnFloor), m);
        return minP == divisionRoundingUp(((float) k / maxApartOnFloor), m) ? minP : 0;
    }

    public static boolean isCorrectData(int floors, int k, int m, int n, int p) {
        if (floors > k) {
            return false;
        }
        int minApart = getMinApartOnFloor(k, floors);
        int pNew = divisionRoundingUp(((float) k / minApart), m);
        return pNew == p && divisionRoundingUp((float) k, minApart) - m * (pNew - 1) == n;
    }

    public static int[] emergency(int k1, int m, int k2, int p2, int n2) {
        int floors = m * (p2 - 1) + n2;
        if (!isCorrectData(floors, k2, m, n2, p2)) {
            return new int[]{-1, -1};
        } else if (k1 == k2) {
            return new int[]{p2, n2};
        } else if (n2 == 1 && p2 == 1) {
            // если этаж и подъезд = 1
            return new int[]{k2 > k1 || k2 * m > k1 ? 1 : 0, m == 1 || k2 > k1 ? 1 : 0};
        } else {
            int minApartOnFloor = getMinApartOnFloor(k2, floors);
            int maxApartOnFloor = getMaxApartOnFloor(k2, floors);
            int n1 = getFloor(k1, minApartOnFloor, maxApartOnFloor, m);
            if (n1 % m == 0 && n1 != 0) {
                n1 = n2;
            } else if (n1 < 0) {
                n1 = 0;
            } else {
                n1 %= m;
            }
            return new int[]{getEntrance(k1, minApartOnFloor, maxApartOnFloor, m), n1};
        }
    }

    public static void check() {
        assert Arrays.equals(emergency(89, 20, 41, 1, 11), new int[]{2, 3});
        assert Arrays.equals(emergency(11, 1, 1, 1, 1), new int[]{0, 1});
        assert Arrays.equals(emergency(3, 2, 2, 2, 1), new int[]{-1, -1});
        assert Arrays.equals(emergency(5, 20, 2, 1, 1), new int[]{1, 0});
        assert Arrays.equals(emergency(20, 20, 2, 1, 1), new int[]{1, 0});
        assert Arrays.equals(emergency(11, 2, 4, 1, 2), new int[]{0, 2});
        assert Arrays.equals(emergency(753, 10, 1000, 1, 1), new int[]{1, 1});
        assert Arrays.equals(emergency(10, 3, 50, 1, 50), new int[]{-1, -1});
        assert Arrays.equals(emergency(6, 3, 18, 1, 1), new int[]{1, 1});
        assert Arrays.equals(emergency(3, 1, 9, 7, 3), new int[]{-1, -1});
        assert Arrays.equals(emergency(3, 1, 2, 1, 1), new int[]{0, 1});
        assert Arrays.equals(emergency(2, 1, 1, 1, 1), new int[]{0, 1});
        assert Arrays.equals(emergency(3, 2, 2, 1, 1), new int[]{1, 0});
        assert Arrays.equals(emergency(2, 3, 1, 1, 1), new int[]{1, 0});
        assert Arrays.equals(emergency(842887, 10, 163729, 24, 8), new int[]{123, 0});
        assert Arrays.equals(emergency(20, 10, 4, 1, 5), new int[]{-1, -1});
    }
}
