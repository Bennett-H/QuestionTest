package test;

import java.util.*;

public class J21Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String postStr = scanner.next();
            String midStr = scanner.next();
            Tree tree = createTree(postStr, 0, postStr.length() - 1, midStr, 0, midStr.length() - 1);
            for (Character c : show(tree)) {
                System.out.print(c);
            }
        }
    }

    static List<Character> show(Tree tree) {
        List<Character> list = new ArrayList<>();
        Queue<Tree> queue = new LinkedList<>();
        if (tree == null) {
            return list;
        }
        queue.offer(tree);
        while (!queue.isEmpty()) {
            Tree poll = queue.poll();
            list.add(poll.val);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return list;
    }

    static Tree createTree(String postStr, int postLeft, int postRight, String midStr, int midLeft, int midRight) {
        if (postLeft > postRight) {
            return null;
        }
        char val = postStr.charAt(postRight);
        int index = midStr.indexOf(val);
        Tree tree = new Tree();
        tree.val = val;
        tree.left = createTree(postStr, postLeft, postLeft + index - midLeft - 1, midStr, midLeft, index - 1);
        tree.right = createTree(postStr, postLeft + index - midLeft, postRight - 1, midStr, index + 1, midRight);
        return tree;
    }

    static class Tree {
        char val;
        Tree left;
        Tree right;
    }
}
