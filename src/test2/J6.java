package test2;

import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/09:46
 * @Description:
 */
public class J6 {
    /**
     * 12345代表 a,ctrl-c,ctrl-x,ctrl-v,ctrl-a
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split(" ");
            StringBuilder screen = new StringBuilder();
            StringBuilder board = new StringBuilder();
            int chooseIdx = -1;
            for (String s : arr) {
                switch (s) {
                    case "1":
                        if (chooseIdx != -1) {
                            if (chooseIdx == screen.length()) {
                                screen = new StringBuilder();
                            } else {
                                screen = new StringBuilder(screen.substring(chooseIdx));
                            }
                            chooseIdx = -1;
                        }
                        screen.append("a");
                        break;
                    case "2":
                        if (chooseIdx != -1) {
                            board = new StringBuilder(screen.substring(0, chooseIdx));
                        }
                        break;
                    case "3":
                        if (chooseIdx != -1) {
                            board = new StringBuilder(screen.substring(0, chooseIdx));
                            screen = new StringBuilder(screen.substring(chooseIdx));
                        }
                        break;
                    case "4":
                        if (chooseIdx != -1) {
                            if (chooseIdx == screen.length()) {
                                screen = new StringBuilder();
                            } else {
                                screen = new StringBuilder(screen.substring(chooseIdx));
                            }
                            chooseIdx = -1;
                        }
                        screen.append(board);
                        break;
                    case "5":
                        chooseIdx = screen.length();
                        break;
                    default:
                        break;
                }
            }
            System.out.println(screen.length());
        }
    }
}
