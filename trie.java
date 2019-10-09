public class TrieNode {
        
    private HashMap<Character, TrieNode> links;
    private boolean isEnd;
        
    public TrieNode() {
        links = new HashMap<>();
        isEnd = false;
    }
    
    public boolean containsKey(char ch) {
        return links.containsKey(ch);
    }
    
    public TrieNode get(char ch) {
        return links.get(ch);
    }
    
    public void put(char ch, TrieNode node) {
        links.put(ch, node);
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
        
}    

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
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        int i = 0;
        while(i < word.length()) {
            if(!node.containsKey(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i++));
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int i = 0;
        while(i < prefix.length()) {
            if(!node.containsKey(prefix.charAt(i)))
                return false;
            node = node.get(prefix.charAt(i++));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
