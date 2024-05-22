package test;

import java.util.ArrayList;
import java.util.Scanner;

public class J38Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            // dp[x] 表示长度为x的树木的最大收益
            int[] dp = new int[n + 1];
            // d[x] 表示最大收益时，最后一节的长度
            int[] d = new int[n + 1];
            // times 表示达到最大收益的次数
            int[] times = new int[n + 1];

            for (int i = 1; i < n + 1; i++) {
                // 长度为i 不切割的收益
                dp[i] = d[i] = i;
                // 对长度为i 进行切割
                for (int j = 0; j < i; j++) {
                    if (dp[i] < j * dp[i - j]) {
                        dp[i] = j * dp[i - j];
                        d[i] = j;
                        times[i] = times[i - j] + 1;
                    } else if (dp[i] == j * dp[i - j] && times[i - j] + 1 < times[i]) {
                        times[i] = times[i - j] + 1;
                        d[i] = j;
                    }
                }
            }
            int index = n;
            ArrayList<Integer> result = new ArrayList<>();
            while (index > 0) {
                result.add(d[index]);
                index -= d[index];
            }
            for (Integer i : result) {
                System.out.print(i + " ");
            }
        }
    }
}
