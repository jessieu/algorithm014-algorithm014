class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> result = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int current = i;
            if (current % 3 == 0) {
                current /= 3;
                sb.append("Fizz");
            }
            if (current % 5 == 0) {
                current /= 5;
                sb.append("Buzz");
            }
            if (sb.length() == 0) {
                sb.append(Integer.toString(i));
            }
            result.add(sb.toString());
        }
        return result;
    }
}

/**
 * This approach won't reduce the asymptotic complexity,
 * but proves to be a neater solution when FizzBuzz comes with a twist.
 */
//class Solution {
//    public List<String> fizzBuzz(int n) {
//        List<String> result = new LinkedList<>();
//
//        for (int i = 1; i <= n; i++) {
//            StringBuilder sb = new StringBuilder();
//            int current = i;
//            if (current % 3 == 0) {
//                current /= 3;
//                sb.append("Fizz");
//            }
//            if (current % 5 == 0) {
//                current /= 5;
//                sb.append("Buzz");
//            }
//            if (sb.length() == 0) {
//                sb.append(Integer.toString(i));
//            }
//            result.add(sb.toString());
//        }
//        return result;
//    }
//}