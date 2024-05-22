package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class J53Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            System.out.println(func(s));
        }
    }

    static String func(String s) {
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ':') {
                nums.add(c - '0');
            }
        }
        String[] strings = s.split(":");
        Integer curH = Integer.parseInt(strings[0]);
        Integer curM = Integer.parseInt(strings[1]);
        ArrayList<Integer> times = new ArrayList<>();
        for (Integer i : nums) {
            for (Integer j : nums) {
                if (i <= 5) {
                    times.add(i * 10 + j);
                }
            }
        }
        times.sort(Comparator.comparingInt(e -> e));
        for (Integer time : times) {
            if (curM < 59 && time <= 59) {
                if (time > curM) {
                    return getResult(curH, time);
                }
            }
        }
        for (Integer time : times) {
            if (curH < 23 && time <= 23) {
                if (time > curH) {
                    return getResult(time, times.get(0));
                }
            }
        }
        return getResult(times.get(0), times.get(0));
    }

    static String getResult(int h, int m) {
        return (h >= 10 ? h : "0" + h) + ":" + (m >= 10 ? m : "0" + m);
    }

}
