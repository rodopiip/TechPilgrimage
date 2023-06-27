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
    public int getMinimumDifference(TreeNode root) {
        int minDifference = Integer.MAX_VALUE;
        TreeNode prev = null;
        TreeNode current = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (!stack.isEmpty() || current!=null){
            while (current!=null){
                stack.push(current);
                current = (TreeNode) current.left;
            }
            current = stack.pop();
            if (prev!=null){
                int diff = Math.abs(current.val-prev.val);
                minDifference = Math.min(minDifference, diff);
            }
            prev = current;
            current = (TreeNode) current.right;
        }
        return minDifference;
    }
}