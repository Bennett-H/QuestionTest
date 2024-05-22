package test;

import java.util.Scanner;

public class J51Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            if (!s.contains("o")) {
                System.out.println(s.length());
            } else {
                char[] charArray = s.toCharArray();
                int result = 0;
                for (int i = 0; i < charArray.length; i++) {
                    int cnt = 0;
                    int count = 0;
                    int j = i;
                    do {
                        if (charArray[j] == 'o') {
                            cnt++;
                        }
                        count++;
                        if (j == charArray.length - 1) {
                            j = 0;
                        } else {
                            j++;
                        }
                    } while (cnt != 3 && j != i);
                    if (cnt == 3) {
                        result = Math.max(result, count - 1);
                    } else if (cnt == 2) {
                        result = Math.max(result, count);
                    }
                }
                System.out.println(result);
            }
        }
    }
}
