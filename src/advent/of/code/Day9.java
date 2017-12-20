package advent.of.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Day9 {
    public static void main(String[] args) throws IOException {
        String input = new String(Files.readAllBytes(Paths.get("src/resource//Day9.txt")));
        int depth = 1;
        int totalPoints = 0;
        boolean garbage = false;
        int garbageCount = 0;
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char char1 = chars[i];
            if (char1 == '!') i++;
            else if (garbage && char1 != '>') garbageCount++;
            else if (char1 == '<') garbage = true;
            else if (char1 == '>') garbage = false;
            else if (char1 == '{') totalPoints += depth++;
            else if (char1 == '}') depth--;
        }
        System.out.println("Part1: " + totalPoints);
        System.out.println("Part2: " + garbageCount);
    }
}