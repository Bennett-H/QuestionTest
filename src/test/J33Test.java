package test;

import java.util.*;
import java.util.stream.Collectors;

public class J33Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] inputStr = s.split(",");
            Map<String, Integer> map = new HashMap<>();
            for (String str : inputStr) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            List<String> list = map.entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue()).map(Map.Entry::getKey).collect(Collectors.toList());
            StringJoiner stringJoiner = new StringJoiner(",");
            for (String string : list) {
                stringJoiner.add(string);
            }
            System.out.println(stringJoiner);
        }
    }
}
