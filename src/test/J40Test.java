package test;

import java.util.Arrays;
import java.util.Scanner;

public class J40Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int[][] qp = new int[19][19];
            int[][] bTag = new int[19][19];
            int[][] wTag = new int[19][19];
            String blackInput = scanner.nextLine();
            int[] black = Arrays.stream(blackInput.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            for (int i = 0; i < black.length - 1; i += 2) {
                qp[black[i]][black[i + 1]] = 1;
            }
            String whiteInput = scanner.nextLine();
            int[] white = Arrays.stream(whiteInput.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
            for (int i = 0; i < white.length - 1; i += 2) {
                qp[white[i]][white[i + 1]] = 1;
            }

            int blackNum = getQI(qp, bTag, black);
            int whiteNum = getQI(qp, wTag, white);
            System.out.println(blackNum + " " + whiteNum);
        }
    }

    static int getQI(int[][] qp, int[][] tag, int[] color) {
        int sum = 0;
        for (int i = 0; i < color.length - 1; i += 2) {
            int x = color[i];
            int y = color[i + 1];
            int up = getVal(qp, x, y - 1);
            if (up == 0 && tag[x][y - 1] == 0) {
                sum++;
                tag[x][y - 1] = 1;
            }
            int down = getVal(qp, x, y + 1);
            if (down == 0 && tag[x][y + 1] == 0) {
                sum++;
                tag[x][y + 1] = 1;
            }
            int left = getVal(qp, x - 1, y);
            if (left == 0 && tag[x - 1][y] == 0) {
                sum++;
                tag[x - 1][y] = 1;
            }
            int right = getVal(qp, x + 1, y);
            if (right == 0 && tag[x + 1][y] == 0) {
                sum++;
                tag[x + 1][y] = 1;
            }
        }
        return sum;
    }

    static int getVal(int[][] qp, int x, int y) {
        if (x < 0 || x > 18 || y < 0 || y > 18) return -1;
        return qp[x][y];
    }
}
