package day1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Day1 {

    private static File uri;
    private static String input;

    private static int total_task1 = 0, total_task2 = 0;

    public static void main(String[] args) {
        uri = new File(args[0]);

        try {
            input = Files.readAllLines(uri.toPath()).get(0);
        } catch (IOException ex) {
            System.out.println("Error reading file");
        }

        System.out.println("Solution Task 1: " + runTask1());
        System.out.println("Solution Task 2: " + runTask2());
    }

    public static int runTask1() {
        String[] arr_input = input.split("");
        int i = 0;
        for (String curr : arr_input) {
            int current = Integer.parseInt(curr);
            if (i != arr_input.length - 1) {
                if (current == Integer.parseInt(arr_input[i + 1])) {
                    total_task1 += current;
                }
            }
            i++;
        }
        if (Integer.parseInt(arr_input[arr_input.length - 1]) == Integer.parseInt(arr_input[0])) {
            total_task1 += Integer.parseInt(arr_input[arr_input.length - 1]);
        }

        return total_task1;
    }

    public static int runTask2() {
        String[] arr_input = input.split("");
        int i = 0;
        for (String curr : arr_input) {
            int current = Integer.parseInt(curr);
            if (i != arr_input.length - 1) {
                int index = (i + (arr_input.length / 2)) % arr_input.length;
                if (current == Integer.parseInt(arr_input[index])) {
                    total_task2 += current;
                }
            }
            i++;
        }

        return total_task2;
    }

}
