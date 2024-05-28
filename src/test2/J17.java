package test2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/11:31
 * @Description:
 */
public class J17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
//            String nums = Pattern.compile("^[0-9]+")
//                    .matcher(scanner.nextLine())
//                    .replaceAll("");
            String nums = scanner.nextLine();
            int[] dp = new int[nums.length()];
//            Arrays.fill(dp, 1);
            int res = 0;
            for (int i = 0; i < nums.length(); ++i) {
                char c = nums.charAt(i);
                if (Character.isDigit(c)) {
                    if (i == 0 || !Character.isDigit(nums.charAt(i - 1))) {
                        dp[i] = 1;
                    } else {
                        if (c == nums.charAt(i - 1) || c == nums.charAt(i - 1) + 1) {
                            dp[i] = dp[i - 1] + 1;
                        } else {
                            dp[i] = 1;
                        }
                    }
                    res = Math.max(dp[i], res);
                }
            }
            System.out.println(res);
        }
    }
}
