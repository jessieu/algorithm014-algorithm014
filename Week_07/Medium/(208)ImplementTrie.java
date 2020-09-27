class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char current = word.charAt(i);
            if (!node.containsKey(current)) {
                node.put(current, new TrieNode());
            }
            node = node.get(current);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char current = prefix.charAt(i);
            if (node.containsKey(current)) {
                node = node.get(current);
            } else {
                return null;
            }
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}

class TrieNode {
    private TrieNode[] links;
    private boolean isEnd;
    private final int R = 26;

    public TrieNode() {
        // each TrieNode links to an array of TrieNodes
        links = new TrieNode[R];
    }

    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }
    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */