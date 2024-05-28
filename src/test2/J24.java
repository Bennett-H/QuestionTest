package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/20:33
 * @Description:
 */
public class J24 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            // 所有合理时间
            String numStr = s.replace(":", "");
            List<Integer> nums = new ArrayList<>();
            for (int i = 0; i < numStr.length(); i++) {
                int a = numStr.charAt(i) - '0';
                if (a <= 5) {
                    for (int j = 0; j < numStr.length(); j++) {
                        int b = numStr.charAt(j) - '0';
                        nums.add(a * 10 + b);
                    }
                }
            }
            nums.sort(Integer::compareTo);
            // 当前时间
            String[] cur = s.split(":");
            int curH = Integer.parseInt(cur[0]);
            int curM = Integer.parseInt(cur[1]);
            //
            System.out.println(gerRes(curH, curM, nums));
        }
    }

    private static String gerRes(int curH, int curM, List<Integer> nums) {
        // 比59小 分钟还可以取更大的
        if (curM < 59) {
            for (Integer num : nums) {
                if (num > curM && num <= 59) {
                    // 小时不变，分钟到下一个
                    return getTime(curH, num);
                }
            }
        }
        // 比23小 小时还可以取更大的
        if (curH < 23) {
            for (Integer num : nums) {
                if (num > curH && num <= 23) {
                    // 小时到了下一个，分钟要取第一个
                    return getTime(num, nums.get(0));
                }
            }
        }
        // 没有更大的，取第一个
        return getTime(nums.get(0), nums.get(0));
    }

    private static String getTime(int h, int m) {
        return (h >= 10 ? String.valueOf(h) : "0" + h) + ":" + (m >= 10 ? String.valueOf(m) : "0" + m);
    }
}
