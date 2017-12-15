package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day6Part2 {
    public static void main (String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/resource//Day6.txt")));
        String[] banks = input.split("\t");
        List<Integer>
                ints = Arrays.stream(banks).map(String::trim).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int cycles = getCombination(getCombination(ints).getInts()).getCycles();
        System.out.println(cycles);
    }

    private static Combination getCombination(List<Integer> ints) {
        Set<String> combinations = new HashSet<>();
        int cycles = 0;
        boolean exists = false;
        while (!exists) {
            int max = ints.stream().max(Integer::compareTo).get();
            int indexOfMax = ints.indexOf(max);
            ints.set(indexOfMax, 0);
            int index = indexOfMax + 1;
            for (int i = 0; i < max; i++) {
                if (index >= ints.size()) {
                    index = 0;
                }
                ints.set(index, ints.get(index) + 1);
                index++;
            }
            if (combinations.contains(ints.toString())) {
                exists = true;
            } else {
                combinations.add(ints.toString());
                cycles++;
            }
        }
        return new Combination(ints, cycles);
    }
    
    public static class Combination{
        private List<Integer> ints;
        private int cycles;
        
        Combination(List<Integer> ints, int cycles) {
            this.ints = ints;
            this.cycles = cycles;
        }
        List<Integer> getInts() {
            return ints;
        }
        int getCycles() {
            return cycles;
        }
    }
}
