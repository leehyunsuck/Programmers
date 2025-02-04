import java.util.*;

class Solution {
    public int solution(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        int answer = 0;
        for (String word : words) {
            answer += trie.findWordMinInput(word);
        }
        
        return answer;
    }
}

class Trie {
    class Node {
        Map<Character, Node> map = new HashMap<>();
        int count = 0;
    }

    Node root;
    
    Trie() {
        this.root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        node.count++;
        
        for (char c : word.toCharArray()) {
            if (!node.map.containsKey(c))
                node.map.put(c, new Node());
            node = node.map.get(c);
            node.count++;
        }
    }
    
    public int findWordMinInput(String word) {
        Node node = root;
    
        for (int i = 0; i < word.length(); i++) {
            node = node.map.get(word.charAt(i));
            if (node.count == 1)
                return i + 1;
        }
        
        return word.length();
    }
}