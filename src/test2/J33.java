package test2;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: Bennett
 * @Date: 2024/05/28/17:11
 * @Description:
 */
public class J33 {

    private static final String REQUEST = "REQUEST";
    private static final String RELEASE = "RELEASE";
    private static final String ERROR = "ERROR";
    private static final int MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.nextLine());
            String[][] c = new String[n][2];
            Map<Integer, Integer> map = new TreeMap<>();
            for (int i = 0; i < n; ++i) {
                c[i] = scanner.nextLine().split("=");
            }
            for (String[] subC : c) {
                int num = Integer.parseInt(subC[1]);
                if (REQUEST.equals(subC[0])) {
                    System.out.println(request(num, map));
                } else {
                    if (map.containsKey(num)) {
                        map.remove(num);
                    } else {
                        System.out.println(ERROR);
                    }
                }
            }
        }
    }

    private static String request(int num, Map<Integer, Integer> map) {
        if (num < 0 || num > MAX) {
            return ERROR;
        } else {
            if (map.isEmpty()) {
                map.put(0, num);
                return "0";
            } else {
                int pre = 0;
                for (Integer key : map.keySet()) {
                    if (key - pre >= num) {
                        map.put(pre, pre + num);
                        return String.valueOf(pre);
                    } else {
                        pre = map.get(key);
                    }
                }
                if (MAX - pre >= num) {
                   map.put(pre, pre + num);
                   return String.valueOf(pre);
                } else {
                    return ERROR;
                }
            }
        }
    }
}
