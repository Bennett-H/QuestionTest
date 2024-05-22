package test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class J28Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String inStr = scanner.nextLine();
            String[] inNums = inStr.split(",");
            String checkStr = scanner.nextLine();
            String[] checkNums = checkStr.split(",");
            if (inNums.length != checkNums.length) {
                System.out.println("NO");
            } else {
                Deque<String> dq = new LinkedList<>();
                StringBuilder result = new StringBuilder();
                int i = 0;
                int j = 0;
                while (i < inNums.length && j < checkNums.length) {
                    dq.offerLast(inNums[i++]);
                    while (!dq.isEmpty() && j < checkNums.length) {
                        if (dq.peekFirst().equals(checkNums[j])) {
                            dq.removeFirst();
                            result.append("L");
                            j++;
                        } else if (dq.peekLast().equals(checkNums[j])) {
                            dq.removeLast();
                            result.append("R");
                            j++;
                        } else {
                            break;
                        }
                    }
                }
                if (result.length() != inNums.length) {
                    System.out.println("NO");
                } else {
                    System.out.println(result);
                }
            }
        }
    }
}
