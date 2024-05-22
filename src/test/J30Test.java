package test;

import java.util.Scanner;

public class J30Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int luck = scanner.nextInt();
            int[] nums = new int[n];
            int max = 0;
            int cur = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
                int padding = nums[i] == luck ? (luck > 0 ? luck + 1 : luck - 1) : nums[i];
                cur += padding;
                max = Math.max(cur, max);
            }
            System.out.println(max);
        }
    }
}
