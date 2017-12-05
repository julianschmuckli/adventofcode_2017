package day5;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day5 {

    private static File uri;
    private static List<String> input;
    private static ArrayList<Integer> jumps = new ArrayList<>();

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

        for (String curr : input) {
            jumps.add(Integer.parseInt(curr));
        }

        System.out.println("Solution Task 1: " + runTask1());
        System.out.println("Solution Task 2: " + runTask2());
    }

    private static int runTask1() {
        jumps.clear();
        for (String curr : input) {
            jumps.add(Integer.parseInt(curr));
        }

        int total_steps = 0;
        int i = 0;
        while (true) {
            int curr = 0;
            try {
                curr = jumps.get(i);
            } catch (IndexOutOfBoundsException ex) {
                break;
            }

            if (curr == 0) {
                jumps.set(i, 1);
            } else {
                jumps.set(i, curr + 1);
                i += curr;
            }
            total_steps++;
        }

        return total_steps;
    }

    private static int runTask2() {
        jumps.clear();
        for (String curr : input) {
            jumps.add(Integer.parseInt(curr));
        }

        int total_steps = 0;
        int i = 0;
        while (true) {
            int curr = 0;
            try {
                curr = jumps.get(i);
            } catch (IndexOutOfBoundsException ex) {
                break;
            }

            if (curr == 0) {
                jumps.set(i, 1);
            } else {
                if ((curr) >= 3) {
                    jumps.set(i, curr - 1);
                } else {
                    jumps.set(i, curr + 1);
                }
                i += curr;
            }
            total_steps++;
        }

        return total_steps;
    }

}
