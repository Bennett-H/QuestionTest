package test;

import java.util.*;

public class J45Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] moneys = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                moneys[i] = scanner.nextInt();
            }
            scanner.nextLine();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n - 1; i++) {
                int[] strings = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
                List<Integer> list = map.getOrDefault(strings[0], new ArrayList<>());
                list.add(strings[1]);
                map.put(strings[0], list);
            }
            int max = Integer.MIN_VALUE;
            for (Integer key : map.keySet()) {
                int cur = moneys[key];
                for (Integer i : map.get(key)) {
                    cur += moneys[i];
                }
                max = Math.max(max, cur);
            }
            System.out.println(max);
        }
    }
}
