/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    // global variable solution

    // int maxDiameter = 0; 

    // public int diameterOfBinaryTree(TreeNode root) {
    //     height(root);
    //     return maxDiameter;
    // }

    // private int height(TreeNode node) {
    //     if (node == null) return 0;

    //     int leftHeight = height(node.left);
    //     int rightHeight = height(node.right);

    //     maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);

    //     return 1 + Math.max(leftHeight, rightHeight);
    // }

    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).diameter;
    }

    private Pair helper(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }

        Pair left = helper(root.left);
        Pair right = helper(root.right);

        int height = 1 + Math.max(left.height, right.height);
        int diameterThroughRoot = left.height + right.height;

        int maxDiameter = Math.max(diameterThroughRoot, Math.max(left.diameter, right.diameter));

        return new Pair(height, maxDiameter);
    }
}

class Pair {
    int height;
    int diameter;

    Pair(int height, int diameter) {
        this.height = height;
        this.diameter = diameter;
    }
}
