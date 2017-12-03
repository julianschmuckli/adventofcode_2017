package day3;

public class Day3 {

    private static int input = 368078;

    public static void main(String[] args) {
        System.out.println("Solution Task 1: " + runTask1());
        System.out.println("Solution Task 2: " + runTask2());
    }

    public static int runTask1() {
        double pow = 0;
        boolean result_found = false;
        int i = 0;
        for (i = 0; i < input; i++) {
            pow = Math.pow(i * 2 + 1, 2);
            if (pow >= input) {
                break;
            }
        }
        //[i][i]
        int x = i, y = -i;
        int site_length = x * 2;

        //Bottom x-line
        int ia;
        for (ia = 0; ia < site_length; ia++) {
            if (pow == input) {
                x -= ia;
                result_found = true;
                break;
            }
            pow--;
        }

        if (!result_found) {
            x -= ia;
            //Left y-line
            int ib;
            for (ib = 0; ib < site_length; ib++) {
                if (pow == input) {
                    y += ib;
                    result_found = true;
                    break;
                }
                pow--;
            }

            if (!result_found) {
                y += ib;
                //Top x-line
                int ic;
                for (ic = 0; ic < site_length; ic++) {
                    if (pow == input) {
                        x += ic;
                        result_found = true;
                        break;
                    }
                    pow--;
                }

                if (!result_found) {
                    x += ic;
                    //Right y-line
                    int id;
                    for (id = 0; id < site_length; id++) {
                        if (pow == input) {
                            y -= id;
                            result_found = true;
                            break;
                        }
                        pow--;
                    }
                    if (!result_found) {
                        y -= id;
                    }
                }
            }
        }

        return (Math.abs(x) + Math.abs(y));
    }

    private static int runTask2() {
        return 0;
    }

}
