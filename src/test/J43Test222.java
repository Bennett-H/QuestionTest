package test;

import java.util.HashMap;
import java.util.Scanner;

public class J43Test222 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] nums = new int[n + 1];
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n + 1; i++) {
               nums[i] = scanner.nextInt();
               map.put((int) Math.pow(2, i), nums[i]);
            }
            int d = scanner.nextInt();
        }
    }
}
