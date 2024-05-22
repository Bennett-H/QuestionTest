package test;

import java.util.Scanner;

public class J15Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                System.out.println(0);
            }
            Node root = new Node();;
            for (int i = 0; i < n; i++) {
                int val = scanner.nextInt();;
                if (i == 0) {
                    root.val = val;
                } else {
                    insert(root, val);
                }
            }
            System.out.println(height(root));
        }
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(Math.max(height(root.right), height(root.mid)), height(root.left)) + 1;
    }

    private static void insert(Node root, int val) {
        if (root.val - 500 > val) {
            if (root.left == null) {
                Node node = new Node();
                node.val = val - 500;
                root.left = node;
            } else {
                insert(root.left, val);
            }
        } else if (root.val - 500 < val) {
            if (root.right == null) {
                Node node = new Node();
                node.val = val + 500;
                root.right = node;
            } else {
                insert(root.right, val);
            }
        } else {
            if (root.mid == null) {
                Node node = new Node();
                node.val = val;
                root.mid = node;
            } else {
                insert(root.mid, val);
            }
        }
    }

    static class Node {
        int val;
        Node left;
        Node mid;
        Node right;
    }
}
