package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Day7 {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/resource//Day7.txt")));
        List<Program> programs = getPrograms(input);
        List<String> names = getAllNames(programs);
        for (String name : names) {
            if (Collections.frequency(names, name) == 1) {
                System.out.println(name);
                break;
            }
        }
    }

    private static List<String> getAllNames(List<Program> programs) {
        List<String> names = new ArrayList<>();
        for (Program program : programs) {
            names.add(program.getName());
            for (String child : program.getChilds()) {
                names.add(child);
            }
        }
        return names;
    }

    private static List<Program> getPrograms(String input) {
        Scanner scanner = new Scanner(input);

        List<Program> programs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] childs = line.split("->");
            List<String> childreen = new ArrayList<>();
            if (childs.length > 1) {
                childreen =
                        Arrays.asList(childs[1].split(", ")).stream().map(String::trim).collect(Collectors.toList());
            }
            String[] programWeight = childs[0].split(" ");
            programs.add(new Program(programWeight[0],
                                     Integer.parseInt(programWeight[1].substring(1, programWeight[1].length() - 1)),
                                     childreen));
        }
        return programs;
    }

    public static class Program {
        private String name;
        private int weight = 0;
        private List<String> childs;

        Program(String name, int weight, List<String> childs) {
            this.name = name;
            this.weight = weight;
            this.childs = childs;
        }

        public String getName() {
            return name;
        }

        public int getWeight() {
            return weight;
        }

        public List<String> getChilds() {
            return childs;
        }
    }
}
