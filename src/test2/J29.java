package test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/28/12:28
 * @Description: [[16,15], [13, 12], [15, 14]]
 */
public class J29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[][] books = new int[n][2];
            for (int i = 0; i < n; ++i) {
                books[i][0] = scanner.nextInt();
                books[i][1] = scanner.nextInt();
            }
            Arrays.sort(books, (b1, b2) -> b1[0] == b2[0] ? b1[1] - b2[1] : b1[0] - b2[0]);

            int[] dp = new int[n];
            int res = 1;
            Arrays.fill(dp, 1);
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (books[i][0] > books[j][0] && books[i][1] > books[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            System.out.println(res);
        }
    }
}
