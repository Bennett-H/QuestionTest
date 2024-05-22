package test;

import java.util.Arrays;
import java.util.Scanner;

public class J36Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int[] seats = Arrays.stream(s.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            int count = 0;
            for (int i = 0; i < seats.length; i++) {
                if (i == 0) {
                    if (seats[i] == 0 && seats[i + 1] == 0) {
                        seats[i] = 1;
                        count++;
                    }
                } else if (i == seats.length - 1) {
                    if (seats[i] == 0 && seats[i - 1] == 0) {
                        seats[i] = 1;
                        count++;
                    }
                } else if (seats[i - 1] == 0 && seats[i] == 0 && seats[i + 1] == 0){
                    seats[i] = 1;
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
