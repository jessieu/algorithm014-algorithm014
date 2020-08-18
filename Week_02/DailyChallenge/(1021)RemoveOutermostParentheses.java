class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        char[] s = S.toCharArray();

        // a counter for tracking open and close parantheses
        int sum = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                if (sum > 0) sb.append(s[i]);
                sum++;
            } else {
                sum--;
                if (sum > 0) sb.append(s[i]);
            }
        }
        return sb.toString();
    }
}

//class Solution {
//    public String removeOuterParentheses(String S) {
//        StringBuilder sb = new StringBuilder();
//
//        int open = 0, close = 0, start = 0;
//        for (int i = 0; i < S.length(); i++) {
//            if (S.charAt(i) == '(') {
//                open++;
//            }
//            if (S.charAt(i) == ')') {
//                close++;
//            }
//
//            if (open == close) {
//                sb.append(S, start+1, i);
//                start = i+1;
//            }
//        }
//        return sb.toString();
//    }
//}