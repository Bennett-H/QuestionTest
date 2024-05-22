package test;

import java.util.Scanner;

public class J41Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int nGPU = scanner.nextInt();
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] arr = new int[n];
            String[] s = scanner.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int task = arr[0];
            int time = 0;
            for (int i = 1; i < n; i++) {
                time++;
                task = Math.max(task - nGPU, 0);
                task += arr[i];
            }
            time += task % nGPU == 0 ? task / nGPU : (task / nGPU + 1);
            System.out.println(time);
        }
    }
}
