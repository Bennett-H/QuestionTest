package test;

import java.util.Scanner;

public class J49Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
//            String binaryString = Integer.toBinaryString(n);
            int length = getBinaryString(n);
            int res;
            for (int i = n + 1; ; i++) {
                if (length == getBinaryString(i)) {
                    res = i;
                    break;
                }
            }
            System.out.println(res);
        }
    }

    static int getBinaryString(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            int m = n % 2;
            n = n / 2;
            builder.append(m);
        }
        return builder.reverse().toString().replaceAll("0", "").length();
    }
}
