package test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/12:14
 * @Description:
 */
public class J19 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            int[] dp = new int[str.length()];
            Arrays.fill(dp, 1);
            int res = 1;
            for (int i = 1; i < str.length(); ++i) {
                if (str.charAt(i) == str.charAt(i - 1)) {
                    dp[i] = dp[i - 1] + 1;
                    res = Math.max(dp[i], res);
                }
            }
            System.out.println(res);
        }
    }
}
