package test2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/18:05
 * @Description:
 * absent：缺勤
 * late：迟到
 * leaveearly：早退
 * present：正常上班
 */
public class J10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[] ans = new String[n];
            Arrays.fill(ans, "TRUE");
            for (int i = 0; i < n; i++) {
                String[] strs = scanner.nextLine().split(" ");
                int aCnt = 0;
                Set<String> set = new HashSet<>();
                set.add("late");
                set.add("leaveearly");
                for (int j = 0; j < strs.length; j++) {
                    if ("absent".equals(strs[i])) {
                        aCnt++;
                        if (aCnt > 1) {
                            ans[i] = "FALSE";
                            break;
                        }
                    }
                    if (j != 0 && set.contains(strs[j - 1]) && set.contains(strs[j])) {
                        ans[i] = "FALSE";
                        break;
                    }
                }
                int cnt = 0;
                int start = 0;
                int end = Math.min(7, strs.length);
                for (int k = start; k < end; ++k) {
                    if (!"present".equals(strs[k])) {
                        cnt++;
                    }
                }
                if (cnt > 3) {
                    ans[end] = "FALSE";
                    break;
                }
                while (end < strs.length) {
                    if (!"present".equals(strs[end++])) {
                        cnt++;
                    }
                    if (!"present".equals(strs[start++])) {
                        cnt--;
                    }
                    if (cnt > 3) {
                        ans[end] = "FALSE";
                        break;
                    }
                }
            }
            for (String an : ans) {
                System.out.println(an);
            }
        }
    }
}
