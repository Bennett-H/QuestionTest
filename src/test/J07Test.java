package test;

import java.util.Scanner;

public class J07Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wa = scanner.nextInt();
        int wb = scanner.nextInt();
        int wt = scanner.nextInt();
        int pa = scanner.nextInt();
        int pb = scanner.nextInt();

        int maxBenefit = Integer.MIN_VALUE;
        for (int i = 1; i < wt / wa; i++) {
            maxBenefit = Math.max(maxBenefit, i * pa + (wt - i * wa) / wb * pb);
        }
        System.out.println(maxBenefit);
    }
}
