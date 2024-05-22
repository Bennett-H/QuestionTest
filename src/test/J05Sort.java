package test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J05Sort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arrs = new int[n][3];
        for (int i = 0; i < n; i++) {
            arrs[i][0] = i + 1;
            arrs[i][1] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrs[i][2] = scanner.nextInt();
        }
        List<Integer> sorts = Arrays.stream(arrs).sorted((e1, e2) -> e1[2] - e2[2]).sorted((e1, e2) -> e1[1] - e2[1]).map(e -> e[0]).collect(Collectors.toList());
        for (Integer sort : sorts) {
            System.out.print(sort + " ");
        }
    }
}
