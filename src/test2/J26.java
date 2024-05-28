package test2;

import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/28/10:03
 * @Description:
 * 0 未访问
 * 1 以访问
 * 2 墙
 * 3 陷阱
 */
public class J26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] map = new int[m][n];
            int k = scanner.nextInt();
            for (int i = 0; i < k; ++i) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                map[x][y] = 2; // 设置墙
            }
            dps(0, 0, map);
            int cnt0 = 0;
            int cnt3 = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    // 全部遍历完 没走的 是未访问
                    if (map[i][j] == 0) {
                        cnt0++;
                    }
                    // 所有陷阱
                    if (map[i][j] == 3) {
                        cnt3++;
                    }
                }
            }
            System.out.println(cnt3 + " " + cnt0);
        }
    }

    // 1能走 0不能走
    private static int dps(int x, int y, int[][] map) {
        int m = map.length;
        int n = map[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || map[x][y] == 2 || map[x][y] == 3) {
            return 0; // 不能走
        }
        map[x][y] = 1;
        // 下面一步必须有
        if (x == m - 1 && y == n - 1) {
            return 1; // 到终点
        }
        int a = dps(x + 1, y, map);
        int b = dps(x, y + 1, map);
        // 两个方向都不能走 是陷阱
        if (a == 0 && b == 0) {
            map[x][y] = 3;
        }
        // 3 不能走 不是3 能走
        return map[x][y] != 3 ? 1 : 0;
    }
}
