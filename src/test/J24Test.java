package test;

import java.util.Arrays;
import java.util.Scanner;

public class J24Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            int[] nums = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
            int result = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    if (nums[i] > 0 && nums.length > 1 && nums[i] > nums[i + 1]) {
                        result++;
                    }
                } else if (i == nums.length - 1) {
                    if (nums[i] > 0 && nums.length > 1 && nums[i] > nums[i - 1]) {
                        result++;
                    }
                } else {
                    if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
