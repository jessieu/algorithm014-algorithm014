class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        int satisfied = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                satisfied++;
                j++;
            }
            i++;
        }
        return satisfied;
    }
}

/**
 * Greedy
 * Sort the array ascendingly.
 * Feed the child with smallest greed factor.
 */