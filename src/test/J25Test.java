package test;

import java.util.Scanner;

public class J25Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int times = scanner.nextInt();
            System.out.println(sum(arr, 0, n - 1, times));
        }
    }

    static int sum(int[] arr, int l, int r, int times) {
        if (l > r || times == 0) {
            return 0;
        }
        return Math.max(arr[l] + sum(arr, l + 1, r, times - 1), arr[r] + sum(arr, l, r - 1, times - 1));
    }
}
