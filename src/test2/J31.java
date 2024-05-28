package test2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/28/15:34
 * @Description:
 */
public class J31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();

            dps(m, n, cur, res);

            System.out.println(res.size());
        }
    }

    private static void dps(int m, int n, List<Integer> cur, List<List<Integer>> res) {
        if (cur.size() == m) {
            if (n == 0) {
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        int start = cur.isEmpty() ? 1 : cur.get(cur.size() - 1);
        int end = cur.isEmpty() ? n / m : Math.min(n, start + 3);
        for (int i = start; i <= end; ++i) {
            cur.add(i);
            dps(m, n - i, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}
