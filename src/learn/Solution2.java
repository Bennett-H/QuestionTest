package learn;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Bennett
 * @Date: 2024/05/24/16:17
 * @Description:
 */
class Solution2 {

    public static void main(String[] args) {
        new Solution2().restoreIpAddresses("25525511135");
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        dps(s, 0, 0, res, cur);
        return res;
    }

    private void dps(String s, int index, int cnt, List<String> res, List<String> cur) {
        if (cnt == 4) {
            if (index == s.length()) {
                res.add(String.join(".", cur));
            }
            return;
        }
        if (index == s.length()) {
            return;
        }
        if (s.charAt(index) == '0') {
            cur.add("0");
            dps(s, index + 1, cnt + 1, res, cur);
            cur.remove(cur.size() - 1);
            return;
        }
        for (int i = 1; i <= 3 && index + i <= s.length(); ++i) {
            int num = Integer.parseInt(s.substring(index, index + i));
            if (num >= 0 && num <= 255) {
                cur.add(s.substring(index, index + i));
                dps(s, index + i, cnt + 1, res, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}