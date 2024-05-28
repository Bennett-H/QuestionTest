package test2;

import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/19:58
 * @Description:
 */
public class J15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            boolean flag = true;
            int sum = 0;
            for (int i = 0; i < str.length(); ++i) {
                char c = str.charAt(i);
                if ('0' <= c && '9' >= c) {
                    if (flag) {
                        sum += c - '0';
                    } else {
                        int j = i;
                        while (j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') {
                            j++;
                        }
                        sum -= Integer.parseInt(str.substring(i, j));
                        i = j - 1;
                        flag = true;
                    }
                } else if ('-' == c) {
                    flag = false;
                }
            }
            System.out.println(sum);
        }
    }
}
