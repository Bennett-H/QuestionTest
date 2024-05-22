package test;

import java.util.Scanner;

public class J34Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String[] datas = s.replaceAll(",", "").replaceAll("0+", "0").split("0");
            int num = 0;
            for (String data : datas) {
                int len = data.length();
                int three = len / 3;
                len %= 3;
                int two = len / 2;
                len %= 2;
                int one = len;
                num += three + two + one;
            }
            System.out.println(num);
        }
    }
}
