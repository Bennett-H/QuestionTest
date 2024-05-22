package test;

import java.util.Arrays;
import java.util.Scanner;

public class J13Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            int len = strings.length;
            if (len > 8) {
                System.out.println("-1");
                continue;
            }
            Integer[] integers = new Integer[len];
            for (int i = 0; i < len; i++) {
                integers[i] = Integer.parseInt(strings[i]);
            }
            Arrays.sort(integers);
            if (len == 8) {
                System.out.println(integers[len - 1]);
                continue;
            }
            int res = Integer.MAX_VALUE;
            for (int i = integers[0]; i <= integers[len - 1]; i++) {
                int sy = 8 - len;
                for (int j = 0; j < len; j++) {
                    int t = integers[j];
                    int times = t % i == 0 ? t / i - 1: t / i;
                    sy -= times;
                    if (sy < 0) {
                        break;
                    }
                }
                if (sy >= 0) {
                    res = Math.min(res, i);
                }
            }
            System.out.println(res);
        }
    }
}
