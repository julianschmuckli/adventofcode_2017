package day4;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
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
        return 0;
    }

}
