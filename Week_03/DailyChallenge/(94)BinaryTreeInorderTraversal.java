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
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            // traverse left subtree all the way down to leaf
            while (current != null) {
                stack.add(current);
                current = current.left;
            }
            // add left child's value
            current = stack.pollLast();
            result.add(current.val);
            // switch to the right branch
            current = current.right;
        }

        return result;
    }
}

//class Solution {
//    private List<Integer> result = new LinkedList<>();
//
//    public List<Integer> inorderTraversal(TreeNode root) {
//        if (root == null) return result;
//        inorderTraversal(root.left);
//        result.add(root.val);
//        inorderTraversal(root.right);
//
//        return result;
//    }
//}