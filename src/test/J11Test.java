package test;

import java.util.Scanner;

public class J11Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(c(s));
    }

    private static int c(String str) {
        int last_m = str.lastIndexOf("$");
        if (last_m < 0) {
            int last_j = str.lastIndexOf("#");
            if (last_j < 0) {
                return Integer.parseInt(str);
            } else {
                return 4 * c(str.substring(0, last_j)) + 3 * c(str.substring(last_j + 1))+ 2;
            }
        } else {
            return 2 * c(str.substring(0, last_m)) + c(str.substring(last_m + 1))+ 3;
        }
    }
}
