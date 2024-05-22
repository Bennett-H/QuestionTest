package test;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringJoiner;

public class J48Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int[] res = new int[n];
//            for (int i = 0; i < n - 1; i++) {
//                for (int j = i; j < n; j++) {
//                    if (arr[i] < arr[j]) {
//                        res[i] = j;
//                        break;
//                    }
//                }
//            }
            Stack<Integer> stack = new Stack<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res[i] = 0;
                } else {
                    res[i] = stack.peek();
                }
                stack.push(i);
            }
            StringJoiner stringJoiner = new StringJoiner(" ");
            for (int i = 0; i < n; i++) {
                stringJoiner.add(String.valueOf(res[i]));
            }
            System.out.println(stringJoiner.toString());
        }
    }
}
