package contest1.J_LinearEquationSystem;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class LinearEquationSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("src/contest1/J_LinearEquationSystem/input.txt"));
             PrintStream printStream = new PrintStream("src/contest1/J_LinearEquationSystem/output.txt")) {
            float a = scanner.nextFloat();
            float b = scanner.nextFloat();
            float c = scanner.nextFloat();
            float d = scanner.nextFloat();
            float e = scanner.nextFloat();
            float f = scanner.nextFloat();
            float[] result = solveSystem(a, b, c, d, e, f);
            for (float v : result) {
                printStream.print(v + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static float[] solveSystem(float a, float b, float c, float d, float e, float f) {
        float det = a * d - b * c;
        if (det == 0) {
            if (a == 0 && c == 0) {
                if (b == 0 && d == 0) {
                    if (e == 0 && f == 0) {
                        return new float[]{5};
                    }
                    return new float[]{0};
                }
                if (e * d != f * b) {
                    return new float[]{0};
                } else if (b != 0) {
                    return new float[]{4, e / b};
                } else {
                    return new float[]{4, f / d};
                }
            }
            if (b == 0 && d == 0) {
                if (e * c != f * a) {
                    return new float[]{0};
                } else {
                    if (a != 0) {
                        return new float[]{3, e / a};
                    } else {
                        return new float[]{3, f / c};
                    }
                }
            }
            if (a != 0) {
                d -= (c / a) * b;
                f -= (c / a) * e;
                if (d == 0 && f == 0) {
                    return new float[]{1, -a / b, e / b};
                }
            } else {
                b -= (a / c) * d;
                e -= (a / c) * f;
                if (b == 0 && e == 0) {
                    return new float[]{1, -c / d, f / d};
                }
            }
            return new float[]{0};
        } else {
            if (d != 0) {
                float x = (e - b * f / d) / (a - b * c / d);
                float y = (f - c * x) / d;
                return new float[]{2, x, y};
            } else {
                float x = (f - d * e / b) / (c - d * a / b);
                float y = (e - a * x) / b;
                return new float[]{2, x, y};
            }
        }
    }
}
