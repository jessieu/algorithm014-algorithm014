/**
 * Dynamic Programming
 */
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] memo = new int[s.length()+1];

        memo[0] = 1;
        memo[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i < memo.length; i++) {
            if (s.charAt(i-1) != '0') {
                memo[i] += memo[i-1];
            }
            int value = Integer.parseInt(s.substring(i-2, i));
            if (value >= 10 && value <= 26) {
                memo[i] += memo[i-2];
            }
        }
        return memo[s.length()];
    }
}
/**
 * Recursion with memoization
 */
//class Solution {
//    private int[] memo; // memorize decode way of substring starting at index i
//    private int decode(String s, int start) {
//        if (start == s.length()) return 1;
//        if (s.charAt(start) == '0') return 0;
//        if (start == s.length() - 1) return 1;
//
//        if (memo[start] > 0) return memo[start];
//        int result = decode(s, start + 1);
//        if (Integer.parseInt(s.substring(start, start + 2)) <= 26) {
//            result += decode(s, start + 2);
//        }
//        memo[start] = result;
//        return result;
//
//    }
//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0) return 0;
//        memo = new int[s.length()];
//        return decode(s, 0);
//    }
//}
/**
 * Recursion
 */
//class Solution {
//    private int decode(String s, int start) {
//        if (start == s.length()) return 1;
//        if (s.charAt(start) == '0') return 0;
//        if (start == s.length() - 1) return 1;
//
//        int result = decode(s, start + 1);
//        if (Integer.parseInt(s.substring(start, start + 2)) <= 26) {
//            result += decode(s, start + 2);
//        }
//        return result;
//
//    }
//    public int numDecodings(String s) {
//        if (s == null || s.length() == 0) return 0;
//        return decode(s, 0);
//    }
//}