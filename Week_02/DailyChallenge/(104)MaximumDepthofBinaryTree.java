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
    public int maxDepth(TreeNode root) {
        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> valStack = new LinkedList<>();

        if (root == null) return 0;
        nodeStack.add(root);
        valStack.add(1);

        int max = Integer.MIN_VALUE;
        while (!nodeStack.isEmpty()) {
            TreeNode current = nodeStack.pollLast();
            int value = valStack.pollLast();

            if (current != null) {
                max = Math.max(max, value);
                nodeStack.add(current.left);
                nodeStack.add(current.right);
                valStack.add(value+1);
                valStack.add(value+1);
            }
        }
        return max;
    }
}

//class Solution {
//    public int maxDepth(TreeNode root) {
//        if (root == null) return 0;
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }
//}