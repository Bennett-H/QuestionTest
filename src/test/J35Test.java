package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class J35Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] strs = new String[n];
            for (int i = 0; i < n; i++) {
                strs[i] = scanner.nextLine();
            }
            char[] chars = scanner.nextLine().toCharArray();
            Set<String> result = new HashSet<>();
            int[] tag = new int[chars.length];
            for (String str : strs) {
                dps(str, 0, chars, result, tag);
            }
            System.out.println(result.size());
        }
    }

    static void dps(String str, int i, char[] chars, Set<String> result, int[] tag) {
        if (i == str.length()) {
            result.add(str);
            return;
        }
        char c = str.charAt(i);
        for (int n = 0; n < chars.length; n++) {
            if (tag[n] == 0 && (chars[n] == c || chars[n] == '?')) {
                tag[n] = 1;
                dps(str, i + 1, chars, result, tag);
                tag[n] = 0;
            }
        }
    }
}
