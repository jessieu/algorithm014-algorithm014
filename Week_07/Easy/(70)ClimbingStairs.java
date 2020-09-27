class Solution {
    private int[] memo;

    // in current position, how many ways I can reach the end
    private int climb (int n, int current) {
        if (current > n) return 0;
        if (current == n) return 1;
        // 剪枝 - only handle staircases we haven't climb
        if (n > 0 && memo[current] > 0) return memo[current];
        memo[current] = climb(n, current + 1) + climb(n, current + 2);
        return memo[current];
    }
    public int climbStairs(int n) {
        if (n <= 2) return n;
        memo = new int[n+1];
        return climb(n, 0);
    }
}