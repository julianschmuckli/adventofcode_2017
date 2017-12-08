package day8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day8 {

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
        HashMap<String, Integer> variables = new HashMap<>();
        for (String curr : input) {
            String[] arr_curr = curr.split(" ");
            String variable = arr_curr[0];
            String how = arr_curr[1];
            int amount = Integer.parseInt(arr_curr[2]);
            String if_variable = arr_curr[4];
            String if_operator = arr_curr[5];
            int if_amount = Integer.parseInt(arr_curr[6]);

            //Add not existing keys
            if (!variables.containsKey(variable)) {
                variables.put(variable, 0);
            }
            if (!variables.containsKey(if_variable)) {
                variables.put(if_variable, 0);
            }

            if (if_operator.equals("<=")) {
                if (variables.get(if_variable) <= if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals(">=")) {
                if (variables.get(if_variable) >= if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals("!=")) {
                if (variables.get(if_variable) != if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals("==")) {
                if (variables.get(if_variable) == if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals("<")) {
                if (variables.get(if_variable) < if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals(">")) {
                if (variables.get(if_variable) > if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            }
        }

        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : variables.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }

        return maxEntry.getValue();
    }

    private static int runTask2() {
        HashMap<String, Integer> variables = new HashMap<>();
        ArrayList<HashMap<String, Integer>> history = new ArrayList<>();
        for (String curr : input) {
            String[] arr_curr = curr.split(" ");
            String variable = arr_curr[0];
            String how = arr_curr[1];
            int amount = Integer.parseInt(arr_curr[2]);
            String if_variable = arr_curr[4];
            String if_operator = arr_curr[5];
            int if_amount = Integer.parseInt(arr_curr[6]);

            //Add not existing keys
            if (!variables.containsKey(variable)) {
                variables.put(variable, 0);
            }
            if (!variables.containsKey(if_variable)) {
                variables.put(if_variable, 0);
            }

            if (if_operator.equals("<=")) {
                if (variables.get(if_variable) <= if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals(">=")) {
                if (variables.get(if_variable) >= if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals("!=")) {
                if (variables.get(if_variable) != if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals("==")) {
                if (variables.get(if_variable) == if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals("<")) {
                if (variables.get(if_variable) < if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            } else if (if_operator.equals(">")) {
                if (variables.get(if_variable) > if_amount) {
                    if (how.equals("dec")) {
                        variables.replace(variable, variables.get(variable) - amount);
                    } else {
                        variables.replace(variable, variables.get(variable) + amount);
                    }
                }
            }

            HashMap<String, Integer> temp = new HashMap<String, Integer>(variables);
            history.add(temp);
        }

        Map.Entry<String, Integer> maxEntry = null;

        for (HashMap<String, Integer> curr : history) {
            for (Map.Entry<String, Integer> entry : curr.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }
        }

        return maxEntry.getValue();
    }
}
