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
    private int[] preorder;
    private int[] inorder;
    private int currentIndex = 0;
    private HashMap<Integer, Integer> map = new HashMap();
    // currentIndex is the index of preorder
    // leftIndex and rightIndex is left and right subtree' boundary in inorder
    private TreeNode builder(int leftIndex, int rightIndex) {
        // leaf node
        if (leftIndex == rightIndex) return null;
        // construct root
        int currentVal = preorder[currentIndex];
        TreeNode current = new TreeNode(currentVal);
        // find next root's index in onorder map
        int index = map.get(currentVal);
        currentIndex++;
        // append left and right subtree recursively
        current.left = builder(leftIndex, index);
        current.right = builder(index + 1, rightIndex);

        return current;

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int index = 0;
        for (int i : inorder) {
            map.put(i, index++);
        }
        return builder(0, inorder.length);
    }
}

// traverse preorder and use it as root
// find current root in inorder
// 0 - currentIndex is in its left subtree
// currentIndex - end is in its right subtree