/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

/**
 * The trick is to add the children backward, because stack is FILO
 * We want the first child popped out first, while in the children list
 * it's also in the first position
 */
class Solution {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) return result;
        stack.add(root);
        while (!stack.isEmpty()) {
            Node current = stack.pollLast();
            result.add(current.val);
            Collections.reverse(current.children);
            for (Node child : current.children) {
                stack.add(child);
            }
        }
        return result;
    }
}

/**
 * Recursive Solution
 */
//class Solution {
//    private LinkedList<Integer> result = new LinkedList<>();
//    public List<Integer> preorder(Node root) {
//        if (root == null) return result;
//        result.add(root.val);
//        for (Node child : root.children) {
//            preorder(child);
//        }
//        return result;
//    }
//}