// create three pointers p3, p5, p7, which will multiple current element by 3, 5, 7 correspondingly
//  1. ugly[0]*3,ugly[1]*3,ugly[2]*3,ugly[3]*3,ugly[4]*3,ugly[5]*3……
//  2. ugly[0]*5,ugly[1]*5,ugly[2]*5,ugly[3]*5,ugly[4]*5,ugly[5]*5……
//  3. ugly[0]*7,ugly[1]*7,ugly[2]*7,ugly[3]*7,ugly[4]*7,ugly[5]*7……
//
//作者：orangex
//链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci/solution/di-k-ge-shu-jiu-shi-xiang-bu-tong-wei-he-san-zhi-z/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
class Solution {
    public int getKthMagicNumber(int k) {
        int p3 = 0, p5 = 0, p7 = 0;
        int[]dp = new int[k+1];
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            dp[i] = Math.min(Math.min(dp[p3] * 3, dp[p5] * 5), dp[p7] * 7);
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
            if (dp[i] == dp[p7] * 7) p7++;
        }
        return dp[k-1];
    }
}