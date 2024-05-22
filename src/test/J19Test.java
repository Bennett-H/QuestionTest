package test;

import java.util.Scanner;

public class J19Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int i = 0;
            int sum = 0;
            while (i < line.length()) {
                if (line.charAt(i) == '-') {
                    i++;
                    if (i < line.length() && line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                        int n = 0;
                        while (i < line.length() && line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                            n = n * 10 + line.charAt(i) - '0';
                            i++;
                        }
                        sum -= n;
                    }
                } else if (line.charAt(i) < '0' || line.charAt(i) > '9') {
                    i++;
                } else {
                    sum += line.charAt(i) - '0';
                    i++;
                }
            }
            System.out.println(sum);
        }
    }
}
