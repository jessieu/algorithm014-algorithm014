class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> map = new HashMap<>();

        // use sorted string as key, anagram as value
        for (String str : strs) {
            char[] s = str.toCharArray();
            Arrays.sort(s);
            String key = String.valueOf(s);
            if (!map.containsKey(key)) {
                map.put(key, new LinkedList<>());
            }
            map.get(key).add(str);
        }
        return new LinkedList(map.values());
    }
}

//class Solution {
//    private boolean isAnagram(String s1, String s2) {
//        if (s1.length() != s2.length())
//            return false;
//        int[] counts = new int[26];
//        for (int i = 0; i < s1.length(); i++) {
//            counts[s1.charAt(i) - 'a']++;
//            counts[s2.charAt(i) - 'a']--;
//        }
//        for (int i = 0; i < counts.length; i++) {
//            if (counts[i] != 0) return false;
//        }
//        return true;
//    }
//
//    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> result = new LinkedList<>();
//
//        for (int i = 0; i < strs.length; i++) {
//            String s = strs[i];
//            // mark the visited string to avoid duplicate
//            if (s == "-") continue;
//            LinkedList<String> temp = new LinkedList<>();
//            for (int j = i+1; j < strs.length; j++) {
//                String t = strs[j];
//                if (t == "-") continue;
//                if (isAnagram(s, t)) {
//                    temp.add(t);
//                    strs[j] = "-";
//                }
//            }
//            temp.add(s);
//            strs[i] = "-";
//            result.add(new LinkedList<>(temp));
//        }
//        return result;
//    }
//}

