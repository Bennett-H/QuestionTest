package test;

import java.util.*;

public class J12Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(",");
        Map<String, List<String>> map = new TreeMap<>();
        for (String string : strings) {
            String pre = string.substring(0, 2);
            String num = string.substring(2);
            List<String> list = map.getOrDefault(pre, new ArrayList<>());
            list.add(num);
            map.put(pre, list);
        }
        StringBuilder sb = new StringBuilder();
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            for (String i : list) {
                sb.append(key).append(i).append(",");
            }
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
