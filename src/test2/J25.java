package test2;

import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/28/09:32
 * @Description:
 */
public class J25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            int left = 0, right = 1;
            int ans = -1;
            while (right < str.length()) {
                right++;
                String subStr = str.substring(left, right);
                if (check(subStr)) {
                    ans = Math.max(ans, subStr.length());
                } else {
                    left++;
                }
            }
            System.out.println(ans);
        }
    }

    private static boolean check (String str) {
        if (str.length() <= 1) {
            return false;
        }
        str = str.replaceAll("[0-9]", "");
        return str.length() == 1;
    }
}
