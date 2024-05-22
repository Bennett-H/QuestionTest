package test;

import java.util.Scanner;

public class J10Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int xCount = 0;
        int yCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'X') {
                xCount++;
            } else {
                yCount++;
            }
            if (xCount == yCount) {
                count++;
                xCount = 0;
                yCount = 0;
            }
        }
        System.out.println(count);
    }
}
