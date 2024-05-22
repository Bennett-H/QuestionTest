package test;

import java.util.Scanner;

public class J37Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            char[] s = scanner.nextLine().toCharArray();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length; i++) {
                char c = s[i];
                if (c != '<') {
                    result.append(c);
                } else {
                    if (result.length() > 0) {
                        result.deleteCharAt(result.length() - 1);
                    }
                }
            }
            System.out.print(result + ",");
            System.out.println(judge(result.toString()) ? "true" : "false");
        }
    }

    static boolean judge(String result) {
        if (result.length() < 8) {
            return false;
        }
        boolean bigFlag = false;
        boolean smallFlag = false;
        boolean numFlag = false;
        boolean flag = false;
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                bigFlag = true;
            } else if (c >= 'a' && c <= 'z') {
                smallFlag = true;
            } else if (c >= '0' && c <= '9') {
                numFlag = true;
            } else {
                flag = true;
            }
        }
        return bigFlag && smallFlag && numFlag && flag;
    }
}
