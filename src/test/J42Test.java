package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class J42Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            int[] nums = Arrays.stream(s.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            System.out.println(set.size());
        }
    }
}
