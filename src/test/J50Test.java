package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class J50Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int[] arr1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            int[] arr2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            int k = scanner.nextInt();
            scanner.nextLine();
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr2.length; j++) {
                    integers.add(arr1[i] + arr2[j]);
                }
            }
            integers.sort(Comparator.comparingInt(e -> e));
            int sum = 0;
            for (int n = 0; n < integers.size() && k > 0; n++, k--) {
                sum += integers.get(n);
            }
            System.out.println(sum);
        }
    }
}
