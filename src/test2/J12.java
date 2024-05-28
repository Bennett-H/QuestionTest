package test2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/27/19:41
 * @Description:
 */
public class J12 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            char[] inputs = scanner.nextLine().toCharArray();
            Deque<Character> stk = new LinkedList<>();
            int res = 0;
            for (char input : inputs) {
                if ('(' == input) {
                    stk.push(input);
                } else {
                    res = Math.max(res, stk.size());
                    stk.pop();
                }
            }
            System.out.println(res);
        }
    }
}
