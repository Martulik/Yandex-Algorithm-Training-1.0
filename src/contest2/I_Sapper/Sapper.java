package contest2.I_Sapper;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Stream;

public class Sapper {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest2/I_Sapper/input.txt"));
             PrintStream ps = new PrintStream("src/contest2/I_Sapper/output.txt")) {
            byte[][] field = new byte[scanner.nextByte()][scanner.nextByte()];
            short nMines = scanner.nextShort();
            for (int i = 0; i < nMines; ++i) {
                byte x = scanner.nextByte();
                byte y = scanner.nextByte();
                field[x - 1][y - 1] = -1;
            }
            fillField(field);
            printField(field, ps);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printField(byte[][] field, PrintStream stream) {
        for (byte[] cell : field) {
            for (int j = 0; j < cell.length; ++j) {
                if (cell[j] == -1) {
                    stream.print("* ");
                } else {
                    stream.print(cell[j] + " ");
                }
            }
            stream.println();
        }
    }

    public static void fillField(byte[][] field) {
        for (int i = 0; i < field.length; ++i) {
            for (int j = 0; j < field[0].length; ++j) {
                if (field[i][j] != -1) {
                    byte left = i != 0 ? field[i - 1][j] : 0;
                    byte right = i != field.length - 1 ? field[i + 1][j] : 0;
                    byte below = j != 0 ? field[i][j - 1] : 0;
                    byte above = j != field[0].length - 1 ? field[i][j + 1] : 0;
                    byte leftAbove = i != 0 && j != field[0].length - 1 ? field[i - 1][j + 1] : 0;
                    byte rightAbove = i != field.length - 1 && j != field[0].length - 1 ? field[i + 1][j + 1] : 0;
                    byte leftBelow = j != 0 && i != 0 ? field[i - 1][j - 1] : 0;
                    byte rightBelow = j != 0 && i != field.length - 1 ? field[i + 1][j - 1] : 0;

                    field[i][j] = (byte) Stream.of(left, right, below, above, leftAbove, rightAbove, leftBelow, rightBelow)
                            .filter(x -> x == -1)
                            .count();
                }
            }
        }
    }
}
