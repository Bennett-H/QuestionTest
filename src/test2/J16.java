package test2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/11:25
 * @Description:
 */
public class J16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int sum = Integer.MAX_VALUE;
            int x = 0;
            int y = 0;
            for (int i = 0; i < nums.length - 1; ++i) {
                for (int j = i + 1; j < nums.length; ++j) {
                    int cur = Math.abs(nums[i] + nums[j]);
                    if (sum > cur) {
                        sum = cur;
                        x = i;
                        y = j;
                    }
                }
            }
            System.out.println(sum + " " + x + " " + y);
        }
    }
}
