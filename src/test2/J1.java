package test2;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Author: Bennett
 * @Date: 2024/05/24/17:53
 * @Description:
 */
public class J1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int k = scanner.nextInt();
            scanner.nextLine();
            String[] arr = scanner.nextLine().split("-");

            StringJoiner ans = new StringJoiner("-");
            ans.add(arr[0]);

            StringBuilder cur = new StringBuilder();
            for (int i = 1; i < arr.length; ++i) {
                cur.append(arr[i]);
            }
            int i = 0;
            while (i + k < cur.length()) {
                ans.add(parseString(cur.substring(i, i + k)));
                i += k;
            }
            if (i < cur.length()) {
                ans.add(parseString(cur.substring(i)));
            }
            System.out.println(ans);
        }
    }

    private static String parseString(String s) {
        int lower = 0;
        int upper = 0;
        for (char c : s.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                lower++;
            }
            if ('A' <= c && c <= 'Z') {
                upper++;
            }
        }
        if (lower > upper) {
            return s.toLowerCase();
        } else if (lower < upper) {
            return s.toUpperCase();
        } else {
            return s;
        }
    }
}
