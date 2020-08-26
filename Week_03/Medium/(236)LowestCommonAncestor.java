/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ancestor;
    private boolean backtracking(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        int left = backtracking(root.left, p, q) ? 1 : 0;
        int right = backtracking(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2)
            ancestor = root;
        return (left + right + mid > 0);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        backtracking(root, p, q);
        return ancestor;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> stack = new LinkedList();
        HashMap<TreeNode, TreeNode> parent = new HashMap(); // child:parent
        parent.put(root, null);
        stack.add(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode current = stack.pollLast();
            if (current.left != null) {
                parent.put(current.left, current);
                stack.add(current.left);
            }
            if (current.right != null) {
                parent.put(current.right, current);
                stack.add(current.right);
            }
        }
        HashSet<TreeNode> set = new HashSet();
        while (p != null) {
            set.add(p);
            p = parent.get(p);
        }
        while (!set.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}