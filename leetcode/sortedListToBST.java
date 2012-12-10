// should have better solution than this

/** * Definition for singly-linked list.

 * public class ListNode {

 *     int val;

 *     ListNode next;

 *     ListNode(int x) { val = x; next = null; }

 * }

 */

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

    public TreeNode sortedListToBST(ListNode head) {

        // Start typing your Java solution below

        // DO NOT write main() function

        ListNode p = head;

        ArrayList<Integer> list = new ArrayList<Integer>();

        while (p != null) {

            list.add(p.val);

            p = p.next;

        }

        return helper(list);

    }

    private TreeNode helper(ArrayList<Integer> list) {

        int len = list.size();

        if (len == 0) return null;

        int rootPos = len / 2;

        TreeNode root = new TreeNode(list.get(rootPos));

        int leftLen = rootPos, rightLen = len - rootPos - 1;

        TreeNode left = null, right = null;

        if (leftLen != 0) {

            left = helper(new ArrayList(list.subList(0, leftLen)));

        }

        if (rightLen != 0) {

            right = helper(new ArrayList(list.subList(rootPos + 1, len)));

        }

        root.left = left;

        root.right = right;

        return root;

       

    }

}

