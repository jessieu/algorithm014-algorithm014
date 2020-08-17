/**
 * Optimal Space Complexity
 * It's actually a hash table, which use the distance between current char and 'a' as key
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // calculate the distance between current char and 'a', use it as index
            arr[s.charAt(i) -'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if (arr[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}

/**
 * Optimal Time Complexity
 */

//class Solution {
//    public boolean isAnagram(String s, String t) {
//        // convert to array
//        char[] cs = s.toCharArray();
//        char[] ct = t.toCharArray();
//        // sort
//        Arrays.sort(cs);
//        Arrays.sort(ct);
//
//        // compare equality
//        return Arrays.equals(cs, ct);
//    }
//}


/**
 * HashMap is pretty slow...
 */

//class Solution {
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        HashMap<Character, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < s.length(); i++) {
//            char cs = s.charAt(i);
//            char ct = t.charAt(i);
//            map.put(cs, map.getOrDefault(cs, 0) + 1);
//            map.put(ct, map.getOrDefault(ct, 0) - 1);
//        }
//
//        for (int i = 0; i < s.length(); i++) {
//            char cs = s.charAt(i);
//            char ct = t.charAt(i);
//            if (map.get(cs) != 0 || map.get(ct) != 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//}