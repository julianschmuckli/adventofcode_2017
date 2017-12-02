package day2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    private static File uri;
    private static List<String> input;
    
    public static void main(String[] args) {
        try{
            uri = new File(args[0]);
        }catch(ArrayIndexOutOfBoundsException ex){
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
        int checksum = 0;
        for(String line : input){
            String[] numbers = line.split("\t");
            ArrayList<Integer> i_numbers = new ArrayList<>();
            for(String curr : numbers){
                i_numbers.add(Integer.parseInt(curr));
            }
            
            int highest_value = Integer.MIN_VALUE, lowest_value = Integer.MAX_VALUE;
            for(int curr : i_numbers){
                if(highest_value < curr){
                    highest_value = curr;
                }
                if(lowest_value > curr){
                    lowest_value = curr;
                }
            }
            int difference = highest_value - lowest_value;
            checksum += difference;
        }
        return checksum;
    }

    private static int runTask2() {
        return 0;
    }
    
}
