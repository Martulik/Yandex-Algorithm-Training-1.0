package contest1.A_Conditioner;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Conditioner {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileReader("input.txt"));
             PrintStream printStream = new PrintStream("output.txt")) {
            int tRoom = scanner.nextInt();
            int tCond = scanner.nextInt();
            String mode = scanner.next();
            if (mode.equals("fan")) {
                printStream.print(tRoom);
            } else if (mode.equals("auto")) {
                printStream.print(tCond);
            } else if (mode.equals("freeze")) {
                printStream.print(Integer.min(tRoom, tCond));
            } else if (mode.equals("heat")) {
                printStream.print(Integer.max(tRoom, tCond));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
