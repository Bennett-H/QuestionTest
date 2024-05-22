package test;

import java.util.Scanner;

/**
 * 螺旋数字矩阵
 */
public class J01SpiralMatrix {

    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);
        int n = scanIn.nextInt();
        int m = scanIn.nextInt();
        int h = n % m == 0 ? n / m : n / m + 1;
        int[][] result = new int[m][h];

        int index = 1;
        int loop = 1;
        while ((loop - 1) * 2 < m && (loop - 1) * 2 < h) {
            index = aaa(loop, index, n, result);
            loop++;
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print((result[i][j] == 0 ? "*" : result[i][j]) + " ");
            }
            System.out.println();
        }
    }

    private static int aaa(int loop, int index, int n, int[][] result) {
        for (int i = loop - 1; i <= result[0].length - loop; i++) {
            if (index <= n) {
                result[loop - 1][i] = index++;
            }
        }
        for (int i = loop; i <= result.length - loop; i++) {
            if (index <= n) {
                result[i][result[0].length - loop] = index++;
            }
        }
        for (int i = result[0].length - loop - 1; i >= loop - 1; i--) {
            if (index <= n) {
                result[result.length - loop][i] = index++;
            }
        }
        for (int i = result.length - loop - 1; i >= loop; i--) {
            if (index <= n) {
                result[i][loop - 1] = index++;
            }
        }
        return index;
    }

}
