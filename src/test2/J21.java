package test2;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/12:36
 * @Description:
 */
public class J21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLong()) {
            long l = scanner.nextLong();
            StringJoiner res = new StringJoiner(" ");
            for (int i = 2; i < Math.sqrt(l); ++i) {
                if (l % i == 0 && isPrime(i) && isPrime(l / i)) {
                    res.add(String.valueOf(i));
                    res.add(String.valueOf(l / i));
                    break;
                }
            }
            if (res.length() == 0) {
                System.out.println("-1 -1");
            } else {
                System.out.println(res);
            }
        }
    }

    private static boolean isPrime(long num) {
        for (int i = 2; i < Math.sqrt(num); ++i) {
            if (num % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
