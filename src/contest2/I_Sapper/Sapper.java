package contest2.I_Sapper;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sapper {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest2/I_Sapper/input.txt"));
             PrintStream ps = new PrintStream("src/contest2/I_Sapper/output.txt")) {
            byte row = scanner.nextByte();
            byte col = scanner.nextByte();
            short nMines = scanner.nextShort();
            List<byte[]> mines = new ArrayList<>(nMines);
            for (int i = 0; i < nMines; ++i) {
                byte x = scanner.nextByte();
                byte y = scanner.nextByte();
                mines.add(new byte[]{x, y});
            }
            byte[][] field = getField(mines, row, col);
            printField(field, ps);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void printField(byte[][] field, PrintStream stream) {
        for (int i = 1; i < field.length - 1; ++i) {
            for (int j = 1; j < field[i].length - 1; ++j) {
                if (field[i][j] == -1) {
                    stream.print("* ");
                } else {
                    stream.print(field[i][j] + " ");
                }
            }
            stream.println();
        }
    }


    public static byte[][] getField(List<byte[]> mines, byte row, byte col) {
        byte[][] offset = new byte[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        byte[][] field = new byte[row + 2][col + 2];

        for (int i = 0; i < mines.size(); ++i) {
            for (int j = 0; j < offset.length; ++j) {
                ++field[mines.get(i)[0] + offset[j][0]][mines.get(i)[1] + offset[j][1]];
            }
        }
        for (byte[] mine : mines) {
            field[mine[0]][mine[1]] = -1;
        }
        return field;
    }
}

