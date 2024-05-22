package test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J27Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int h = scanner.nextInt();
            int n = scanner.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = scanner.nextInt();
                arr[i][1] = Math.abs(h - arr[i][0]);
            }
            List<Integer> collect = Arrays.stream(arr).sorted((e1, e2) -> e1[1] - e2[1] == 0 ? e1[0] - e2[0] : e1[1] - e2[1]).map(e -> e[0]).collect(Collectors.toList());
            for (Integer i : collect) {
                System.out.print(i + " ");
            }
        }
    }
}
