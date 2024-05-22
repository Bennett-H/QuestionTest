package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class J08Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] strings = Arrays.stream(s.split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(strings[0]);
        res.add(strings[1]);
        if (strings.length > 2) {
            for (int i = 2; i < strings.length - 3; i = i + 2) {
                if (isPoint(i, strings)) {
                    res.add(strings[i]);
                    res.add(strings[i + 1]);
                }
            }
            res.add(strings[strings.length - 2]);
            res.add(strings[strings.length - 1]);
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    static boolean isPoint(int i, int[] strings) {
        int preX = strings[i - 2];
        int preY = strings[i - 1];
        int X = strings[i];
        int Y = strings[i + 1];
        int postX = strings[i + 2];
        int postY = strings[i + 3];
        return (preX- X) * (preY - Y) != (X - postX) * (Y - postY);
    }
}
