package contest3.F_AlienGenome;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class AlienGenome {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/contest3/F_AlienGenome/input.txt"));
             PrintStream ps = new PrintStream("src/contest3/F_AlienGenome/output.txt")) {
            Map<String, Integer> genomes1 = getGenomes(br.readLine().toCharArray());
            Map<String, Integer> genomes2 = getGenomes(br.readLine().toCharArray());
            int result = 0;
            for (String key : genomes1.keySet()) {
                if (genomes2.containsKey(key)) {
                    result += genomes1.get(key);
                }
            }
            ps.print(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Map<String, Integer> getGenomes(char[] str) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length - 1; ++i) {
            String genome = String.valueOf(str[i]).concat(String.valueOf(str[i + 1]));
            if (!map.containsKey(genome)) {
                map.put(genome, 1);
            } else {
                map.put(genome, map.get(genome) + 1);
            }
        }
        return map;
    }


}
