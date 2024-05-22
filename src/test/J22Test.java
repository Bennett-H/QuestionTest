package test;

import java.util.*;

public class J22Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            Tree tree = createTree(arr);
            List<Integer> result = new ArrayList<>();
            show(tree, result);
            for (Integer i : result) {
                System.out.print(i + " ");
            }
        }
    }

    static void show(Tree tree, List<Integer> result) {
        if (tree == null) {
            return;
        }
        show(tree.left, result);
        result.add(tree.val);
        show(tree.right, result);
    }

    static Tree createTree(int[] arr) {
        PriorityQueue<Tree> trees = new PriorityQueue<>((e1, e2) -> e1.val - e2.val);
        for (int i = 0; i < arr.length; i++) {
            trees.offer(new Tree(arr[i]));
        }
        while (trees.size() > 1) {
            Tree left = trees.poll();
            Tree right = trees.poll();
            Tree tree = new Tree(left.val + right.val);
            tree.left = left;
            tree.right = right;
            trees.offer(tree);
        }
        return trees.poll();
    }

    static class Tree {
        int val;
        Tree left;
        Tree right;

        public Tree(int val) {
            this.val = val;
        }
    }
}
