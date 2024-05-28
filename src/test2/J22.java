package test2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/12:55
 * @Description:
 */
public class J22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            Deque<String> opStk = new LinkedList<>();
            Deque<Integer> numStk = new LinkedList<>();

            int idx = 0;
            int numIdx = 0;
            boolean flag = true;
            while (idx < input.length()) {
                char c = input.charAt(idx);
                if (c == '(') {
                    opStk.push(input.substring(idx + 1, idx + 4));
                    // 操作数后的 空格位
                    idx += 4;
                    // 空格位后的数字
                    numIdx = idx + 1;
                } else if (c == ')') {
                    if (numIdx < idx) {
                        numStk.push(Integer.parseInt(input.substring(numIdx, idx)));
                        // 下一个空格后的数字
                        numIdx = idx + 1;
                    }
                    // c
                    flag = c(opStk, numStk);
                    if (!flag) {
                        System.out.println("error");
                        break;
                    }
                    idx++;
                } else {
                    if (c == ' ' && idx > numIdx) {
                        numStk.push(Integer.parseInt(input.substring(numIdx, idx)));
                        // 下一个空格后的数字
                        numIdx = idx + 1;
                    }
                    idx++;
                }
            }
            if (flag) {
                System.out.println(numStk.peek());
            }
        }
    }

    private static boolean c (Deque<String> opStk, Deque<Integer> numStk) {
        String op = opStk.pop();
        int num2 = numStk.pop();
        int num1 = numStk.pop();
        switch (op) {
            case "mul" :
                numStk.push(num1 * num2);
                break;
            case "add" :
                numStk.push(num1 + num2);
                break;
            case "sub" :
                numStk.push(num1 - num2);
                break;
            case "div" :
                if (num2 == 0) {
                    return false;
                }
                numStk.push(num1 / num2);
                break;
            default:
        }
        return true;
    }
}
