// same pattern as the subset problem
class Solution {
    private List<List<Integer>> result = new LinkedList<>();
    private int n;
    private void backtracking(int first, int k, LinkedList<Integer>current) {
        if (current.size() == k) {
            result.add(new LinkedList(current));
            return;
        }

        for (int i = first; i <= n; i++) {
            current.add(i);
            backtracking(i+1, k, current);
            current.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        backtracking(1, k, new LinkedList<Integer>());
        return result;
    }
}