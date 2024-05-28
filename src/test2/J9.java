package test2;

import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/17:59
 * @Description:
 */
public class J9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            System.out.println(getRes(n));
        }
    }

    private static String getRes(int n) {
        if (n == 1) {
            return "11";
        }
        String str = getRes(n - 1);
        int count = 1;
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < str.length(); ++i) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                res.append(count).append(str.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }
        res.append(count).append(str.charAt(str.length() - 1));
        return res.toString();
    }
}
