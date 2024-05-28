package test2;

import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/28/16:08
 * @Description:
 */
public class J32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            StringBuilder nums = new StringBuilder(scanner.nextLine());
            int n = Integer.parseInt(scanner.nextLine());
            if (n >= nums.length()) {
                System.out.println("");
            } else {
                while (n > 0) {
                    // 找到第一个下降的数 下标
                    int end = getFirstDown(nums);
                    // 依次往前 删除比当前下标
                    int i = end - 1;
                    while (i >= 0) {
                        if (i == nums.length() - 1 || nums.charAt(i) > nums.charAt(i + 1)) {
                            nums.deleteCharAt(i--);
                            if (--n == 0) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                System.out.println(nums);
            }
        }
    }

    private static int getFirstDown(StringBuilder nums) {
        for(int i = 1; i < nums.length(); ++i) {
            if (nums.charAt(i) < nums.charAt(i - 1)) {
                return i;
            }
        }
        return nums.length();
    }
}