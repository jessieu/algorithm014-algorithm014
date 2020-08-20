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
 * Recursion
 */
class Solution {
    private List<List<Integer>> result = new LinkedList<>();

    private void traverseNode(Node root, int level) {
        if (result.size() <= level) {
            result.add(new LinkedList<>());
        }
        result.get(level).add(root.val);
        for (Node child : root.children) {
            traverseNode(child, level + 1);
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        if (root != null) traverseNode(root, 0);
        return result;
    }
}

/**
 * Iteration - slower than the recursion
 */
//class Solution {
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> result = new LinkedList<>();
//        LinkedList<Node> queue = new LinkedList<>();
//
//        if (root == null) return result;
//
//        queue.add(root);
//
//        while (!queue.isEmpty()) {
//            LinkedList<Integer> temp = new LinkedList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node node = queue.pollFirst();
//                temp.add(node.val);
//                queue.addAll(node.children);
//            }
//            result.add(new LinkedList<>(temp));
//        }
//        return result;
//    }
//}