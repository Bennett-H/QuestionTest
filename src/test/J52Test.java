package test;

import java.util.Scanner;

public class J52Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            char[] charArray = scanner.nextLine().toCharArray();
            int result = 0;
            boolean hasDigit = false;
            boolean hasChar = false;
            for (int i = 0, j = 0; i < charArray.length; i++) {
                if (charArray[i] >= '0' && charArray[i] <= '9') {
                    hasDigit = true;
                    result = Math.max(result, i - j + 1);
                } else {
                    hasChar = true;
                    for (int k = i - 1; k >= j; k--) {
                        if (!(charArray[k] >= '0' && charArray[k] <= '9')) {
                            j = k + 1;
                            break;
                        }
                    }
                    result = Math.max(result, i - j + 1);
                }
            }
            if (hasChar && hasDigit) {
                System.out.println(result);
            } else {
                System.out.println("-1");
            }
        }
    }
}
