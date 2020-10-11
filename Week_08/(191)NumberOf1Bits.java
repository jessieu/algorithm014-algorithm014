/**
 * n & n - 1 will remove the 1 in LSB
 */
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}

//public class Solution {
//    // you need to treat n as an unsigned value
//    public int hammingWeight(int n) {
//        int count = 0;
//        int mask = 1;
//        for (int i = 0; i < 32; i++) {
//            if ((n & mask) != 0) {
//                count++;
//            }
//            mask <<= 1;
//        }
//        return count;
//    }
//}