import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start
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
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> values = new ArrayList<Integer>();

        while (root != null) {
            if (root.left == null) {
                values.add(root.val);
                root = root.right;
            } else {
                TreeNode rightMost = root.left;

                while (rightMost.right != null && rightMost.right != root) {
                    rightMost = rightMost.right;
                }

                if (rightMost.right == null) {
                    values.add(root.val);
                    rightMost.right = root;
                    root = root.left;
                } else {
                    rightMost.right = null;
                    root = root.right;
                }
            }
        }

        return values;
    }
}
// @lc code=end

