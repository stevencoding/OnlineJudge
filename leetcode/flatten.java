/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        
        if (root.left != null) {
            flatten(root.left);
        }
        if (root.right != null) {
            flatten(root.right);
        }
        TreeNode left = root.left, right = root.right;
        if (left == null) return;
        root.left = null;
        root.right = left;
        TreeNode p = left;
        while (p.right != null) p = p.right;
        p.right = right;      
    }
}