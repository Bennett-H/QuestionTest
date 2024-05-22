package test;

import java.util.Scanner;

public class J16Test {
    public static void main(String[] args) {
//        test1();
        test2();
//        test3();
    }

    private static void test3() {
        // 出租车实际就是9进制数转10进制
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int res = 0;
        int nL = 0;
        while (n != 0) {
            int gt = n % 10;
            res = gt * (int) Math.pow(9, nL) + res * 10;
            n /= 10;
            nL++;
        }
        System.out.println(res);
    }

    private static void test2() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String str = "" + i;
            if (!str.contains("4")) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int nL = 0;
        while (n >= Math.pow(10, nL)) {
            nL++;
        }
        for (int i = nL; i > 0; i--) {
            int gw = n % (int)Math.pow(10, i) / (int)Math.pow(10, i - 1); //i 的位数
            if (gw > 4) {
                n -= (int)Math.pow(10, i - 1);
            }
            int a = n / (int)Math.pow(10, i - 1);
            int b = a / 10;
            n -= b * (int)Math.pow(10, i - 1);
        }
        System.out.println(n);
    }
}
