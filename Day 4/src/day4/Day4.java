package day4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day4 {

    private static File uri;
    private static List<String> input;

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
        int valid_phrases = 0;
        outerloop:
        for (String curr_passphrase : input) {
            ArrayList<String> list = new ArrayList<>();
            String[] curr_arr_passphrase = curr_passphrase.split(" ");
            for (String curr_password : curr_arr_passphrase) {
                if (!list.contains(curr_password)) {
                    list.add(curr_password);
                } else {
                    continue outerloop;
                }
            }
            valid_phrases++;
        }
        return valid_phrases;
    }

    private static int runTask2() {
        int valid_phrases = 0;

        outerloop:
        for (String curr_passphrase : input) {
            ArrayList<ArrayList<Integer>> total_asciisum = new ArrayList<>();

            String[] words = curr_passphrase.split(" ");

            //Add characters to an arraylist and sort it
            for (String curr_word : words) {
                char[] chars = curr_word.toCharArray();

                ArrayList<Integer> temp_word = new ArrayList<>();
                for (char chr : chars) {
                    temp_word.add((int) chr);
                }
                Collections.sort(temp_word);
                total_asciisum.add(temp_word);
            }

            int total = 0;
            for (ArrayList<Integer> curr_outer : total_asciisum) {
                for (ArrayList<Integer> curr : total_asciisum) {
                    if (curr.size() == curr_outer.size()) {
                        if (curr != curr_outer && curr.equals(curr_outer)) {
                            total++;
                        }
                    }
                }
            }
            if (total == 0) {
                valid_phrases++;
            }
        }
        return valid_phrases;
    }
}
