/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(1, n);
    }
    private ArrayList<TreeNode> helper(int head, int tail) {
        ArrayList<TreeNode> list = new ArrayList<TreeNode>();
        TreeNode root;
        if (head > tail) {
            root = null;
            list.add(root);
        } else if (head == tail) {
            root = new TreeNode(head);
            list.add(root);
        } else {
            int rootPos;
            ArrayList<TreeNode> leftList, rightList;
            for (rootPos = head; rootPos <= tail; rootPos++) {
                leftList = helper(head, rootPos - 1);
                rightList = helper(rootPos + 1, tail);
                for (TreeNode left : leftList) {
                    for (TreeNode right : rightList) {
                        root = new TreeNode(rootPos);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }
        }
        return list;
    }
}