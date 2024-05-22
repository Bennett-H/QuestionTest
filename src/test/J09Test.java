package test;

import java.util.Scanner;

public class J09Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int sx = scanner.nextInt();
        int sy = scanner.nextInt();
        int t = scanner.nextInt();
        int[][] arr = new int[h][w];
        scanner.nextLine();
        for (int i = 0; i < h; i++) {
            String s = scanner.nextLine();
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        if (w == 1 && h == 1) {
            System.out.println(arr[0][0] * t);
            return;
        }
        int sum = 0;
        for (int i = 0; i <= t; i++) {
            sum += arr[y][x];
            if (x == 0 && sx < 0) {
                sx = -sx;
            }
            if (x == w - 1 && sx > 0) {
                sx = -sx;
            }
            if (y == 0 && sy < 0) {
                sy = -sy;
            }
            if (y == h - 1 && sy > 0) {
                sy = -sy;
            }
            x += sx;
            y += sy;
        }
        System.out.println(sum);
    }
}
