package test2;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/09:22
 * @Description:
 */
public class J5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int c = scanner.nextInt();
            int b = scanner.nextInt();
            int[] nums = new int[10];
            for (int i = 0; i < 10; ++i) {
                nums[i] = scanner.nextInt();
            }
            System.out.println(c(c, b, nums));
        }
    }

    private static int c (int c, int b, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        c = 0x01;
        int res = 0;
        for (int num : nums) {
            int y = intByteSum(num) % b;
            if (y < c) {
                int cur = map.getOrDefault(y, 0);
                map.put(y, cur + 1);
                res = Math.max(res, cur + 1);
            }
        }
        return res;
    }

    private static int intByteSum(int x) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println(x >> (i * 8));
            System.out.println((byte) x >> (i * 8));
            sum += (byte) (x >> (i * 8));
            System.out.println(sum);
        }
        return sum;
    }

}


