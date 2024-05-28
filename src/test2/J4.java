package test2;

import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/09:16
 * @Description:
 */
public class J4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String t = scanner.nextLine();
            System.out.println(judge(s, t));
        }
    }

    private static boolean judge (String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int sIdx = 0;
        int tIdx = 0;

        while (sIdx < s.length() && tIdx < t.length()) {
            if (s.charAt(sIdx) == t.charAt(tIdx)) {
                sIdx++;
            }
            tIdx++;
        }

        return sIdx == s.length();
    }
}
