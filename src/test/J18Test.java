package test;

import java.util.*;
import java.util.stream.Collectors;

public class J18Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }
            int y = scanner.nextInt();
            ArrayList<Page> pages = new ArrayList<>();
            for (Integer key : map.keySet()) {
                Page page = new Page();
                page.no = key;
                page.num = map.get(key);
                if (page.num >= y) {
                    pages.add(page);
                }
            }
            if (pages.isEmpty()) {
                System.out.println(0);
            } else {
                List<Integer> collect = pages.stream().sorted((e1, e2) -> e2.num - e1.num).sorted((e1, e2) -> e1.no - e2.no).map(e -> e.no).collect(Collectors.toList());
                System.out.println(collect.size());
                for (Integer i : collect) {
                    System.out.println(i);
                }
            }
        }
    }

    static class Page {
        int no;
        int num;
    }
}
