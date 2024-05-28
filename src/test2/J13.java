package test2;

import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/10:50
 * @Description:
 */
public class J13 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();

            int[] a = new int[50];
            a[0] = 1;
            a[1] = 2;
            a[2] = 4;
            for (int i = 3; i < 50; ++i) {
                a[i] = a[i - 1] + a[i - 2] + a[i - 3];
            }

            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; ++i) {
                charArray[i] += a[i];
                if (charArray[i] <= 'a' || charArray[i] >= 'z') {
                    charArray[i] = (char) ('a' + charArray[i] % 26);
                }
            }
            System.out.println(new String(charArray));
        }
    }
}
