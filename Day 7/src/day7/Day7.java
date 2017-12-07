package day7;

import day7.model.Program;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Day7 {

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

    private static String runTask1() {
        ArrayList<Program> list = new ArrayList<>();
        for (String curr : input) {
            int weight = Integer.parseInt(curr.split("\\(")[1].split("\\)")[0]);
            String name = curr.split(" \\(")[0];

            String[] childs = new String[0];
            try {
                childs = curr.split("-> ")[1].split(", ");
            } catch (ArrayIndexOutOfBoundsException ignore) {
            }
            list.add(new Program(weight, name, childs));
        }

        //Set the roots
        for (Program curr : list) {
            if (curr.getRoot().equals("")) {
                for (Program curr_a : list) {
                    if (curr_a == curr) {
                        continue;
                    }

                    if (Arrays.asList(curr_a.getChilds()).contains(curr.getName())) {
                        curr.setRoot(curr_a.getName());
                        break;
                    }
                }
            }
        }

        int index = 0;
        String parent = "";
        outerloop:
        do {
            Program curr = list.get(index);
            if (curr.getRoot().equals("")) {
                break;
            }
            parent = curr.getRoot();

            //Find the new index
            int i = 0;
            for (Program curr_parent : list) {
                if (curr_parent.getName().equals(parent)) {
                    index = i;
                    continue outerloop;
                }
                i++;
            }
        } while (true);

        return parent;
    }

    private static String runTask2() {
        return "";
    }

}
