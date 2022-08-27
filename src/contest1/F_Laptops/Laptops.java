package contest1.F_Laptops;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

class IntPair implements Comparable<IntPair> {
    private int x;
    private int y;

    public IntPair() {
    }

    public IntPair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getArea() {
        return this.x * this.y;
    }

    @Override
    public int compareTo(IntPair pair) {
        return this.getArea() - pair.getArea();
    }
}

public class Laptops {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest1/F_Laptops/input.txt"));
             PrintStream printStream = new PrintStream("src/contest1/F_Laptops/output.txt")) {
            List<IntPair> listOfSides = new ArrayList<>();
            while (scanner.hasNext()) {
                IntPair pair = new IntPair();
                pair.setX(scanner.nextInt());
                if (scanner.hasNext()) {
                    pair.setY(scanner.nextInt());
                    listOfSides.add(pair);
                }
            }
            IntPair minPair = getMinTableSize(listOfSides);
            printStream.print(minPair.getX() + " " + minPair.getY());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static IntPair getMinTableSize(List<IntPair> list) {
        return Collections.min(Arrays.asList(
                contactVertically(list.get(0), list.get(1)),
                contactHorizontally(list.get(0), list.get(1)),
                contactTurningHorizontally(list.get(0), list.get(1)),
                contactTurningVertically(list.get(0), list.get(1))));
    }

    public static IntPair contactVertically(IntPair pair1, IntPair pair2) {
        return new IntPair(Math.max(pair1.getX(), pair2.getX()), pair1.getY() + pair2.getY());
    }

    public static IntPair contactHorizontally(IntPair pair1, IntPair pair2) {
        return new IntPair(pair1.getX() + pair2.getX(), Math.max(pair1.getY(), pair2.getY()));
    }

    public static IntPair contactTurningHorizontally(IntPair pair1, IntPair pair2) {
        return new IntPair(Math.max(pair1.getX(), pair2.getY()), pair1.getY() + pair2.getX());
    }

    public static IntPair contactTurningVertically(IntPair pair1, IntPair pair2) {
        return new IntPair(Math.max(pair1.getY(), pair2.getX()), pair1.getX() + pair2.getY());
    }
}
