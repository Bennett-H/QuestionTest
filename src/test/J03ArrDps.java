package test;

import java.util.*;

/**
 * 数组数dps
 */
public class J03ArrDps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArr = str.split(" ");
        Map<String, List<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String s : strArr) {
            String[] task = s.split("->");
            String left = task[0];
            String right = task[1];
            if (!map.containsKey(left)) {
                map.put(left, new ArrayList<>());
            }
            map.get(left).add(right);
            if (!map.containsKey(right)) {
                map.put(right, new ArrayList<>());
            }
        }
        while (!map.isEmpty()) {
            Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, List<String>> next = iterator.next();
                if (next.getValue().isEmpty()) {
                    result.add(next.getKey());
                    iterator.remove();
                }
            }
            for (String key : map.keySet()) {
                Iterator<String> iteratorList = map.get(key).iterator();
                while (iteratorList.hasNext()) {
                    if (!map.containsKey(iteratorList.next())) {
                        iteratorList.remove();
                    }
                }
            }
        }
        System.out.println(String.join(" ", result));
    }
}
