package test2;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: Bennett
 * @Date: 2024/05/28/11:29
 * @Description: a{b{d,e{g,h{,i}}},c{f}}
 */
public class J28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            char[] array = scanner.nextLine().toCharArray();
            Deque<Node> stk = new LinkedList<>();
            for (int i = 0; i < array.length; i++) {
                char c = array[i];
                if (Character.isLetter(c)) { // a
                    Node node = new Node(c);
                    stk.push(node);
                } else if (c == '{' && Character.isLetter(array[i + 1])) { // {a
                    Node node = new Node(array[i + 1]);
                    stk.peek().left = node;
                    stk.push(node);
                    i += 1;
                } else if (c == '{' && array[i + 1] == ',') { // {,
                    Node node = new Node(array[i + 2]);
                    stk.peek().right = node;
                    stk.push(node);
                    i += 2;
                } else if (array[i] == ',' && Character.isLetter(array[i + 1])) { // ,a
                    stk.pop();
                    Node node = new Node(array[i + 1]);
                    stk.peek().right = node;
                    stk.push(node);
                    i += 1;
                } else if (array[i] == '}') {
                    stk.pop();
                }
            }
            StringBuilder res = new StringBuilder();
            mid(stk.peek(), res);
            System.out.println(res);
        }
    }

    private static void mid(Node root, StringBuilder res) {
        if (root == null) {
            return;
        }
        mid(root.left, res);
        res.append(root.val);
        mid(root.right, res);
    }

    static class Node {
        char val;
        Node left;
        Node right;

        Node(char val) {
            this.val = val;
        }
    }
}
