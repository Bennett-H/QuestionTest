package test;

import java.util.ArrayList;
import java.util.Scanner;

public class J23Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(scanner.nextInt());
            }
            int jump = scanner.nextInt();
            int left = scanner.nextInt();
            for (int i = (jump + 1) % list.size(); list.size() > left; i = (i + jump) % list.size()) {
                list.remove(i);
            }
            int sum = list.stream().mapToInt(e -> e).sum();
            System.out.println(sum);
        }
    }
}
