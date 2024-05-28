package test2;

import java.util.*;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/10:17
 * @Description:
 */
public class J8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int len = Integer.parseInt(scanner.nextLine());
            int n = Integer.parseInt(scanner.nextLine());
            String[] strs = new String[n];
            for (int i = 0; i < n; ++i) {
                strs[i] = scanner.nextLine();
            }
            System.out.println(c(len, strs));
        }
    }

    private static String c(int len, String[] strs) {
        StringJoiner res = new StringJoiner(",");
        List<LinkedList<String>> list = new ArrayList<>();
        int sum = 0;
        for (String str : strs) {
            String[] split = str.split(",");
            list.add(new LinkedList<>(Arrays.asList(split)));
            sum += split.length;
        }
        int cnt = 0;
        while (cnt != sum) {
            for (List<String> subList : list) {
                int times = Math.min(subList.size(), len);
                for (int i = 0; i < times; ++i) {
                    res.add(subList.remove(0));
                }
                cnt += times;
            }
        }
        return res.toString();
    }
}
