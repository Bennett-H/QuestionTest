package test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class J06Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] features = new int[n + 1];
        for (int i = 1; i < features.length; i++) {
            features[i] = scanner.nextInt();
        }
        int[][] testSum = new int[m][2];
        scanner.nextLine();
        for (int i = 0; i < testSum.length; i++) {
            testSum[i][1] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(a -> {
                int b = Integer.parseInt(a);
                return features[b];
            }).sum();
            testSum[i][0] = i + 1;
        }
        List<Integer> sorts = Arrays.stream(testSum).sorted((e1, e2) -> e2[1] - e1[1] == 0 ? e1[0] - e2[0] : e2[1] - e1[1]).map(e -> e[0]).collect(Collectors.toList());
        for (Integer sort : sorts) {
            System.out.print(sort + " ");
        }
    }
}
