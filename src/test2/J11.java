package test2;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/10:34
 * @Description:
 */
public class J11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] strs = scanner.nextLine().split("\\s+");
            int start = Integer.parseInt(scanner.nextLine());
            int end = Integer.parseInt(scanner.nextLine());
            StringJoiner res = new StringJoiner(" ");

            start = Math.max(0, start);
            end = Math.min(end, strs.length - 1);
            if (start == end || start > strs.length - 1 || end < 0) {
                System.out.println("EMPTY");
            } else {
                while (start < end) {
                    String temp = strs[start];
                    strs[start] = strs[end];
                    strs[end] = temp;
                    start++;
                    end--;
                }
                for (String str : strs) {
                    res.add(str);
                }
                System.out.println(res.toString());
            }
        }
    }
}
