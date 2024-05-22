package test;

import java.util.Scanner;

public class J17Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        boolean[][] tag = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = Math.max(res, func(arr, tag, i, j));
            }
        }
        System.out.println(res);
    }

    private static int func(int[][] arr, boolean[][] tag, int i, int j) {
        int result = 0;
        if (i < 0 || i > arr.length - 1 || j < 0 || j > arr[0].length - 1 || arr[i][j] == 0 || tag[i][j]) {
            return 0;
        }
        if (arr[i][j] == 1 && !tag[i][j]) {
            result++;
        }
        tag[i][j] = true;

        result += func(arr, tag, i + 1, j);
        result += func(arr, tag, i - 1, j);
        result += func(arr, tag, i, j + 1);
        result += func(arr, tag, i, j - 1);
        return result;
    }
}
