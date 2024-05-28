package test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/24/18:11
 * @Description:
 */
public class J2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] nums = scanner.nextLine().split(",");
            // 返回负数是前面的在前，返回正数是后面的在前
            Arrays.sort(nums, (e1, e2) -> {
                char[] arr1 = e1.toCharArray();
                char[] arr2 = e2.toCharArray();
                int len1 = arr1.length;
                int len2 = arr2.length;

                if (len1 == len2) {
                    return e2.compareTo(e1);
                }

                int minL = Math.min(len1, len2);
                for (int i = 0; i < minL; ++i) {
                    char c1 = arr1[i];
                    char c2 = arr2[i];
                    if (c1 != c2) {
                        return c2 - c1;
                    }
                }

                if (len1 < len2) {
                    return arr2[minL] - arr2[0];
                } else {
                    return arr1[0] - arr1[minL];
                }
            });
            StringBuilder res = new StringBuilder();
            for (String num : nums) {
                res.append(num);
            }
            System.out.println(res);
        }
    }
}
