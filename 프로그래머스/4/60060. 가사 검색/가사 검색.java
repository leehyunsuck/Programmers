import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Trie> basicMap = new HashMap<>(),
                           reverseMap = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            
            if (!basicMap.containsKey(len)) basicMap.put(len, new Trie());
            if (!reverseMap.containsKey(len)) reverseMap.put(len, new Trie());
            
            basicMap.get(len).insert(word);
            reverseMap.get(len).insert(new StringBuilder(word).reverse().toString());
        }
        
        int[] answer = new int[queries.length];
        for (int idx = 0; idx < answer.length; idx++) {
            String prefix = queries[idx].replace("?", "");
            int len = queries[idx].length();
            
            if (!basicMap.containsKey(len)) {
                answer[idx] = 0;
                continue;
            }
            
            boolean isBasic = queries[idx].charAt(0) != '?';
            
            answer[idx] = isBasic ? basicMap.get(len).getCountSearch(prefix)
                                  : reverseMap.get(len).getCountSearch(new StringBuilder(prefix).reverse().toString());
        }
        
        return answer;
    }
}

class Trie {
    class Node {
        Map<Character, Node> map = new HashMap<>();
        int count = 0;
    }
    
    private Node root = new Node();
    
    public void insert(String word) {
        Node node = root;
        node.count++;
        for (char c : word.toCharArray()) {
            if (!node.map.containsKey(c)) node.map.put(c, new Node());
            node = node.map.get(c);
            node.count++;
        }
    }
    
    public int getCountSearch(String prefix) {
        Node node = root;
        
        for (char c : prefix.toCharArray()) {
            if (!node.map.containsKey(c)) return 0;
            node = node.map.get(c);
        }
        return node.count;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (1.04ms, 87.4MB)
테스트 2 〉	통과 (0.76ms, 76MB)
테스트 3 〉	통과 (0.72ms, 82.5MB)
테스트 4 〉	통과 (0.76ms, 82.8MB)
테스트 5 〉	통과 (0.79ms, 75.9MB)
테스트 6 〉	통과 (0.92ms, 81.4MB)
테스트 7 〉	통과 (5.44ms, 76.1MB)
테스트 8 〉	통과 (3.21ms, 92.1MB)
테스트 9 〉	통과 (6.08ms, 88.4MB)
테스트 10 〉	통과 (7.80ms, 92.1MB)
테스트 11 〉	통과 (3.84ms, 87.5MB)
테스트 12 〉	통과 (8.05ms, 87.9MB)
테스트 13 〉	통과 (22.67ms, 91.5MB)
테스트 14 〉	통과 (11.23ms, 98.7MB)
테스트 15 〉	통과 (20.51ms, 83.9MB)
테스트 16 〉	통과 (28.20ms, 106MB)
테스트 17 〉	통과 (13.23ms, 76.4MB)
테스트 18 〉	통과 (17.31ms, 82.7MB)

효율성  테스트
테스트 1 〉	통과 (541.82ms, 165MB)
테스트 2 〉	통과 (1079.82ms, 211MB)
테스트 3 〉	통과 (911.79ms, 198MB)
테스트 4 〉	실패 (메모리 초과)
테스트 5 〉	실패 (메모리 초과)

로직은 문제 없음 -> 메모리 최적화 필요 -> 모름 -> (질문하기) 참고 -> 트라이 자료구조?

import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Map<Integer, Map<String, Integer>> backStart = new HashMap<>(),     // ?가 뒤에서부터 시작
                                           frontStart = new HashMap<>();    // ?가 앞에서부터 시작
        Map<Integer, Integer> allMap = new HashMap<>();
        
        for (String word : words) {
            int len = word.length();
            putSearchMap(len, word, backStart, frontStart);
            allMap.put(len, allMap.getOrDefault(len, 0) + 1);
        }
        
        int[] answer = new int[queries.length];
        for (int idx = 0; idx < answer.length; idx++) {
            String search = queries[idx];
            int len = search.length();
            
            boolean isAll  = search.charAt(0) == '?' && search.charAt(len - 1) == '?',
                    isBack = search.charAt(len - 1) == '?';
            
            if (isAll) answer[idx] = allMap.getOrDefault(len, 0);
            else {
                search = search.replace("?", "");
                
                answer[idx] = isBack ? (backStart.containsKey(len) ? backStart.get(len).getOrDefault(search, 0) : 0)
                                     : (frontStart.containsKey(len) ? frontStart.get(len).getOrDefault(search, 0) : 0);
            }
        }
 
        return answer;
    }
    
    private void putSearchMap(int len, String word,
                              Map<Integer, Map<String, Integer>> backStart,
                              Map<Integer, Map<String, Integer>> frontStart) {
        StringBuilder backBuilder = new StringBuilder(),
                      frontBuilder = new StringBuilder();
        Map<String, Integer> backMap  = backStart.getOrDefault(len, new HashMap<>()),
                             frontMap = frontStart.getOrDefault(len, new HashMap<>());
        for (int idx = 0; idx < len - 1; idx++) {
            String backWord = frontBuilder.toString();
            frontBuilder.setLength(0);
            
            backBuilder.append(word.charAt(idx));
            frontBuilder.append(word.charAt(len - 1 - idx)).append(backWord);
            
            String backKey  = backBuilder.toString(),
                   frontKey = frontBuilder.toString();
            
            backMap.put(backKey, backMap.getOrDefault(backKey, 0) + 1);
            frontMap.put(frontKey, frontMap.getOrDefault(frontKey, 0) + 1);
        }
        
        backStart.put(len, backMap);
        frontStart.put(len, frontMap);
    }
}
*/