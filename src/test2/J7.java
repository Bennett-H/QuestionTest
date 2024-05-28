package test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/17:04
 * @Description:
 */
public class J7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int[] nums = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).sorted().toArray();
            int count = 0;

            for (int i = 0; i < nums.length; ++i) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                for (int j = 0; j < nums.length; ++j) {
                    if (j != 0 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    for (int k = nums.length - 1; k >= 0; --k) {
                        if (k != nums.length - 1 && nums[k] == nums[k + 1]) {
                            continue;
                        }
                        if (i == j || j == k || i == k) {
                            continue;
                        }
                        int sum = a(nums[i], nums[j]);
                        if (sum == nums[k]) {
                            count++;
                            System.out.println(sum + " " + nums[i] + " " + nums[j]);
                        }
                        if (sum > nums[k]) {
                            break;
                        }
                    }
                }
            }
            if (count == 0) {
                System.out.println(0);
            }
        }
    }

    private static int a (int b, int c) {
        return b + 2 * c;
    }
}
