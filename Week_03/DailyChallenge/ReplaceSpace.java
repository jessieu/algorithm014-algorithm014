class Solution {
    public String replaceSpace(String s) {
        int len = s.length();
        char[] sArr = new char[len * 3];

        int index = 0;
        for (int i = 0; i < len; i++) {
            char current = s.charAt(i);
            if (current == ' ') {
                sArr[index++] = '%';
                sArr[index++] = '2';
                sArr[index++] = '0';
            } else {
                sArr[index++] = current;
            }
        }
        return new String(sArr, 0, index);
    }
}
//class Solution {
//    public String replaceSpace(String s) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < s.length(); i++) {
//            char current = s.charAt(i);
//            if (current == ' ') {
//                sb.append("%20");
//            } else {
//                sb.append(current);
//            }
//        }
//        return sb.toString();
//    }
//}