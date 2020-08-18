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

/**
 * Recursive Solution
 */
//class Solution {
//    LinkedList<Integer> result = new LinkedList<>();
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) return result;
//        inorderTraversal(root.left);
//        result.add(root.val);
//        inorderTraversal(root.right);
//        return result;
//    }
//}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // traverse left substree all the way to the end
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            // add left child to result
            current = stack.pollLast();
            result.add(current.val);
            // switch to the right
            current = current.right;
        }
        return result;
    }
}