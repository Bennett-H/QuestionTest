package test;

import java.util.Scanner;

/**
 * 结队编程
 */
public class J02JDBC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = scanner.nextInt();
        }
        int result = 0;
        result += asc(arr);
        result += desc(arr);
        System.out.println(result);
    }

    private static int asc(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; ++i) {
            int a = arr[i];
            for (int j = i + 1; j < arr.length; ++j) {
                int b = arr[j];
                if (a >= b) continue;
                for (int k = j + 1; k < arr.length; ++k) {
                    int c = arr[k];
                    if (b >= c) continue;
                    result++;
                }
            }
        }
        return result;
    }

    private static int desc(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; ++i) {
            int a = arr[i];
            for (int j = i + 1; j < arr.length; ++j) {
                int b = arr[j];
                if (a <= b) continue;
                for (int k = j + 1; k < arr.length; ++k) {
                    int c = arr[k];
                    if (b <= c) continue;
                    result++;
                }
            }
        }
        return result;
    }
}
