package test;

import java.util.*;

public class J31Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] strings = s.split(" ");
            char[] charArray = strings[0].toCharArray();
            int n = Integer.parseInt(strings[1]);
            Set<String> result = new HashSet<>();
            List<Character> list = new ArrayList<>();
            int[] tag = new int[charArray.length];
            dps(charArray, n, result, list, tag);
            System.out.println(result.size());
        }
    }

    static void dps(char[] charArray, int n, Set<String> result, List<Character> list, int[] tag) {
        if (list.size() == n) {
            StringBuilder builder = new StringBuilder();
            for (Character c : list) {
                builder.append(c);
            }
            result.add(builder.toString());
        }
        for (int i = 0; i < charArray.length; i++) {
            if (tag[i] == 0) {
                if (list.isEmpty() || list.get(list.size() - 1) != charArray[i]) {
                    list.add(charArray[i]);
                    tag[i] = 1;
                    dps(charArray, n, result, list, tag);
                    list.remove(list.size() - 1);
                    tag[i] = 0;
                }
            }
        }
    }

}
