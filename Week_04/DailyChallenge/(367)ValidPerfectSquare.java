/* Newton's Iteration:
 * 1. Next Guess:
 *    x(i+1) = x(i) - f(x) / f'(x)
 *    f(x) = x ^ 2 - num because it's equivalent to find f(x) = 0
 *    f'(x) = 2x
 * 2. Stop at:
 *    x * x > num
 * 3. Verify
 *    root * root == num
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;
        long x = num / 2; // x might overflow

        while (x * x > num) {
            x = (x + num / x) / 2 ;
        }

        return (x * x == num);
    }
}

/*
 * bisection (aka. binary search)
 */
//class Solution {
//    public boolean isPerfectSquare(int num) {
//        if (num < 2) return true;
//        int left = 0, right = num / 2;
//
//        while (left <= right) {
//            int root = left + (right - left) / 2;
//            int square = root * root;
//            if (root * root == num) {
//                return true;
//            } else if (root * root < num) {
//                // search right half
//                left = root + 1;
//            } else {
//                // search left half
//                right = root - 1;
//            }
//        }
//        return false;
//    }
//}