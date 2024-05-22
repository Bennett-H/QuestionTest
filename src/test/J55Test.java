package test;

import java.util.Scanner;

public class J55Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arrs = new int[n];
            for (int i = 0; i < n; i++) {
                arrs[i] = scanner.nextInt();
            }
            int money = scanner.nextInt();
            int result = 0;
            for (int i = 0; i < n; i++) {
                int cur = money;
                int curN = 0;
                int curIndex = i;
                while (cur >= 0 && curIndex < n) {
                    cur -= arrs[curIndex++];
                    curN++;
                }
                curN = cur < 0 ? curN - 1 : curN;
                result = Math.max(result, curN);
            }
            System.out.println(result);
        }
    }
}
