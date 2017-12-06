package day6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day6 {

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

        String[] arr_input = input.get(0).split("\t");
        for (String curr : arr_input) {
            memory_banks.add(Integer.parseInt(curr));
        }

        System.out.println("Solution Task 1: " + runTask1());
        System.out.println("Solution Task 2: " + runTask2());
    }

    private static int runTask1() {
        int cycles = 0;
        ArrayList<int[]> memory_banks_history = new ArrayList<>();

        outerloop:
        do {
            int i = 0;
            int highest_value = 0, highest_value_index = 0;

            for (int curr : memory_banks) {
                if (curr > highest_value) {
                    highest_value = curr;
                    highest_value_index = i;
                }
                i++;
            }

            int index = highest_value_index + 1;
            if (index >= memory_banks.size()) {
                index = 0;
            }
            for (i = 0; i < highest_value; i++) {
                memory_banks.set(highest_value_index, memory_banks.get(highest_value_index) - 1);
                memory_banks.set(index, memory_banks.get(index) + 1);

                if (index >= (memory_banks.size() - 1)) {
                    index = 0;
                } else {
                    index++;
                }
            }

            cycles++;

            ArrayList<Integer> temp = memory_banks;
            int[] temp_arr = new int[temp.size()];
            int ia = 0;
            for (int curr : temp) {
                temp_arr[ia] = curr;
                ia++;
            }

            for (int[] curr : memory_banks_history) {
                if (Arrays.equals(curr, temp_arr)) {
                    break outerloop;
                }
            }

            memory_banks_history.add(temp_arr);
        } while (true);
        return cycles;
    }

    private static int runTask2() {
        int cycles = 0;
        boolean already_seen = false;
        ArrayList<int[]> memory_banks_history = new ArrayList<>();

        outerloop:
        do {
            int i = 0;
            int highest_value = 0, highest_value_index = 0;

            for (int curr : memory_banks) {
                if (curr > highest_value) {
                    highest_value = curr;
                    highest_value_index = i;
                }
                i++;
            }

            int index = highest_value_index + 1;
            if (index >= memory_banks.size()) {
                index = 0;
            }
            for (i = 0; i < highest_value; i++) {
                memory_banks.set(highest_value_index, memory_banks.get(highest_value_index) - 1);
                memory_banks.set(index, memory_banks.get(index) + 1);

                if (index >= (memory_banks.size() - 1)) {
                    index = 0;
                } else {
                    index++;
                }
            }

            if (already_seen) {
                cycles++;
            }

            ArrayList<Integer> temp = memory_banks;
            int[] temp_arr = new int[temp.size()];
            int ia = 0;
            for (int curr : temp) {
                temp_arr[ia] = curr;
                ia++;
            }

            for (int[] curr : memory_banks_history) {
                if (Arrays.equals(curr, temp_arr)) {
                    if (already_seen) {
                        break outerloop;
                    } else {
                        memory_banks_history.clear();
                        already_seen = true;
                        continue outerloop;
                    }
                }
            }

            memory_banks_history.add(temp_arr);
        } while (true);
        return cycles - 1;
    }

}
