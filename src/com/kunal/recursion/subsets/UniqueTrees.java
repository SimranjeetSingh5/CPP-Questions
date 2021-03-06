package com.kunal.recursion.subsets;

import java.util.*;

/*
    Time: O(N * 2^N)
    Space: O(2^N)
*/
public class UniqueTrees {
    public static List<TreeNode> findUniqueTrees(int n) {
        List<TreeNode> nodes = findUniqueTrees(1, n);
        return nodes;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countTrees(int n) {
        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        return count;
    }

    private static List<TreeNode> findUniqueTrees(int start, int end) {
        List<TreeNode> nodes = new LinkedList<>();

        if (start > end) {
            nodes.add(null);
            return nodes;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = findUniqueTrees(start, i - 1);
            List<TreeNode> right = findUniqueTrees(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    nodes.add(root);
                }
            }
        }

        return nodes;
    }

    public static void main(String[] args) {
        List<TreeNode> result = UniqueTrees.findUniqueTrees(2);
        System.out.print("Total trees: " + result.size());
    }
}
