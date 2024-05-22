package learn;

import java.util.*;

public class caipiao {

    public static void main(String[] args) {
        for (String s : "/a/./b/../../c/".split("/")) {
            System.out.println(s + ":" + s.length());
        }
        StringJoiner stringJoiner = new StringJoiner("/");
        System.out.println(stringJoiner);
        System.out.println(getJX());

        System.out.println("abc".substring(0, 3));
    }

    private static String getJX() {
        Set<String> set = new HashSet<>();
        while (set.size() != 6) {
            set.add(getRed());
        }
        StringJoiner reds = new StringJoiner(",");
        for (String i : set) {
            reds.add(i);
        }
        return  "reds:" +
                reds +
                " blue:" +
                getBlue();
    }


    private static String getRed() {
        return (int) (1 + Math.random() * 33) + "";
    }

    private static String getBlue() {
        return (int) (1 + Math.random() * 16) + "";
    }
}
