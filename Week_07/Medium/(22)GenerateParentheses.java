class Solution {
    private List<String> result;
    private void dfs(String s, int left, int right) {
        // terminator - invalid case
        if (left > right) {
            return;
        }
        // handle current level's logic - use up all brackets
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        // drill down - 剪枝
        if (left > 0) dfs(s +"(", left - 1, right);
        if (right > 0) dfs(s +")", left, right -1);
    }

    public List<String> generateParenthesis(int n) {
        result = new LinkedList();
        dfs("", n, n);
        return result;
    }
}