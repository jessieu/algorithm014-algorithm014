/**
 * x & x - 1 set the rightmost 1-bit to 0
 * if n is the power of n, there's only one 1-bit
 */
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}

/**
 * -x = ~x + 1
 * x & (-x) keeps the rightmost 1-bit
 */
//class Solution {
//    public boolean isPowerOfTwo(int n) {
//        if (n == 0) return false;
//        long x = (long) n;
//        return (x & (-x)) == x;
//    }
//}