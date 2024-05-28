package test2;

import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/11:57
 * @Description:
 */
public class J18 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int flag = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                nums[i] = scanner.nextInt();
                /**
                 * a ^ b 二进制  a和b相同 0  a和b不同 1
                 * 又叫 “不进位加法”
                 */
                flag ^= nums[i];
                // 所有数之和
                sum += nums[i];
                // 最小数
                min = Math.min(min, nums[i]);
            }
            if (flag != 0) {
                System.out.println("NO");
            } else {
                // flag == 0
                System.out.println(sum - min);
            }
        }
    }
}
