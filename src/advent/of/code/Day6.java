package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day6 {
    public static void main (String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/resource//Day6.txt")));
        int cycles = 0;
        String[] banks = input.split("\t");
        List<Integer> ints = Arrays.stream(banks).map(String::trim).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Set<String> combinations = new HashSet<>(); 
        boolean exists = false;
        while (!exists) {
            int max = ints.stream().max(Integer::compareTo).get();
            int indexOfMax = ints.indexOf(max   );
            ints.set(indexOfMax, 0);
            int index = indexOfMax + 1;
            for (int i = 0; i < max; i++) {
                if (index >= ints.size()) {
                    index = 0;
                }
                ints.set(index, ints.get(index) + 1);
                index++;
            }
            cycles++;
            if (combinations.contains(ints.toString())) {
                exists = true;
            } else {
                combinations.add(ints.toString());
            }
        }
        System.out.print(cycles);
    }
}
