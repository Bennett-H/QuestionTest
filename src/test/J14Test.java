package test;

import java.util.Scanner;

public class J14Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int e = scanner.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < arr.length; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = scanner.nextInt();
                if (i != 0) {
                    arr[i][1] += arr[i - 1][1];
                }
            }
            int sum = 0;
            // i==0情况的面积是0
            for (int i = 1; i < n; i++) {
                int w = arr[i][0] - arr[i - 1][0];
                int h = Math.abs(arr[i - 1][1]);
                sum += w * h;
            }
            sum += (e - arr[n - 1][0]) * Math.abs(arr[n - 1][1]);
            System.out.println(sum);
        }
    }
}
