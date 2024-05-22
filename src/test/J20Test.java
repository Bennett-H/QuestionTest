package test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class J20Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            Tree tree = createTree(nums, 0);
            System.out.println(cost(tree));
        }
    }

    static int cost(Tree tree) {
        if (tree == null) {
            return 0;
        } else {
            return tree.val + Math.max(cost(tree.left), cost(tree.right));
        }
    }

    static Tree createTree(int[] nums, int index) {
        if (index >= nums.length) {
            return null;
        } else {
            if (nums[index] == -1) {
                return null;
            } else {
                Tree tree = new Tree();
                tree.val = nums[index];
                tree.left = createTree(nums, 2 * index + 1);
                tree.right = createTree(nums, 2 * index + 2);
                return tree;
            }
        }
    }

    static class Tree {
        int val;
        Tree left;
        Tree right;
    }
}
