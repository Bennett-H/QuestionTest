package test2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/28/10:45
 * @Description: 高效的任务规划
 * 贪心算法：
 * 结论：先配置运行时间长的机器。
 * 证明：假设有两台机器，机器A的配置时间为c1，运行时间为r1，机器B的配置时间为c2，运行时间为r2，同时假设r2 > r1;
 * 那么，先配置A再配置B的时间所需要花费的最小时间为
 * max(c1 + r1, c1 + c2 + r2);
 * 先配置B再配置A的时间所需要花费的时间为：
 * max(c2 + r2, c2 + c1 + r1);
 * 由于r2 > r1, 且c1 > 0 ,那么max(c1 + r1, c1 + c2 + r2) = c1 + c2 + r2；
 * 此外，c1 + c2 + r2 > c2 + r2 ，c1 + c2 + r2 > c2 + c1 + r1，
 * 也就是说max(c1 + r1, c1 + c2 + r2) > max(c2 + r2, c2 + c1 + r1)
 * 即运行时间长的需要先配置，才能保证最后的时间最短。
 * 因此可按照运行时间的降序进行排序。每次比较并取max(c2 + r2, c2 + c1 + r1)，即可得到答案。
 */
public class J27 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        for (int i = 0; i < m; ++i) {
            int n = scanner.nextInt();
            int[][] ms = new int[n][2];
            for (int j = 0; j < n; ++j) {
                ms[j][0] = scanner.nextInt();
                ms[j][1] = scanner.nextInt();
            }
            // 运行时间长的 在前
            Arrays.sort(ms, (e1, e2) -> e2[1] - e1[1]);
            // 前面所有配置时间和 下一个任务的开始节点
            int preTime = 0;
            // 当前任务和前面所有配置时间和
            int time = 0;
            // preTime + bpre + jpre 和 preTime + bpre + bnow + jnow 的大值
            int ans = 0;
            for (int[] ints : ms) {
                int B = ints[0];
                int J = ints[1];

                time = preTime + B + J;
                ans = Math.max(ans, time);
                preTime += B;
            }
            System.out.println(ans);
        }
    }
}
