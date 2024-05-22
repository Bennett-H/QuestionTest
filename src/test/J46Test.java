package test;

import java.util.ArrayList;
import java.util.Scanner;

public class J46Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<String> result = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                int sum = 0;
                StringBuilder builder = new StringBuilder();
                builder.append(n).append("=");
                for (int j = i; sum <= n; ++j) {
                    sum += j;
                    builder.append(j).append("+");
                    if (sum == n) {
                        builder.deleteCharAt(builder.length() - 1);
                        result.add(builder.toString());
                    }
                }
            }
            result.sort((e1, e2) -> e1.length() - e2.length() == 0 ? e1.compareTo(e2) : e1.length() - e2.length());
            for (String s : result) {
                System.out.println(s);
            }
            System.out.println("Result:" + result.size());
        }
    }
}
