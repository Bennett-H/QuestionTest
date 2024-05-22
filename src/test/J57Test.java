package test;

import java.util.Scanner;

public class J57Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            String[] arrs = new String[n];
            for (int i = 0; i < n; i++) {
                arrs[i] = scanner.nextLine();
            }
            String[] iii = scanner.nextLine().split(" ");
            int index = Integer.parseInt(iii[0]);
            String key = iii[1];
            int num = 0;
            for (String arr : arrs) {
                String[] strings = arr.split("/");
                if (strings.length > index && strings[index].equals(key)) {
                    num++;
                }
            }
            System.out.println(num);
        }
    }
}
