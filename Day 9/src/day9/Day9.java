package day9;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day9 {

    private static File uri;
    private static List<String> input;

    private static ArrayList<Integer> memory_banks = new ArrayList<>();

    public static void main(String[] args) {
        try {
            uri = new File(args[0]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            uri = new File("input.txt"); //Default
        }

        try {
            input = Files.readAllLines(uri.toPath());
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }

        System.out.println("Solution Task 1: " + runTask1());
        System.out.println("Solution Task 2: " + runTask2());
    }

    private static int runTask1() {
        String input = Day9.input.get(0);

        boolean curr_ignored = false, curr_garb = false;
        int sum = 0, total = 0;
        for (char curr : input.toCharArray()) {
            if (curr_ignored) {
                curr_ignored = false;
                continue;
            }
            if (curr == '!') {
                curr_ignored = true;
                continue;
            }

            if (curr_garb && curr == '>') {
                curr_garb = false;
                continue;
            } else if (curr_garb) {
                continue;
            }

            if (!curr_garb && curr == '<') {
                curr_garb = true;
            }

            if (curr == '{') {
                sum++;
                total += sum;
                continue;
            } else if (curr == '}') {
                sum--;
                continue;
            }
        }

        return total;
    }

    private static int runTask2() {
        String input = Day9.input.get(0);

        boolean curr_ignored = false, curr_garb = false;
        int total = 0;
        for (char curr : input.toCharArray()) {
            if (curr_ignored) {
                curr_ignored = false;
                continue;
            }
            if (curr == '!') {
                curr_ignored = true;
                continue;
            }

            if (curr_garb && curr == '>') {
                curr_garb = false;
                continue;
            } else if (curr_garb) {
                total++;
                continue;
            }

            if (!curr_garb && curr == '<') {
                curr_garb = true;
            }
        }

        return total;
    }

}
