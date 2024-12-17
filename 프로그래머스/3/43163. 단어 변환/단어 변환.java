import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // 변할 수 있는 단어 (contains 메소드 쓰려고)
        Set<String> set = new HashSet<>();
        for (String word : words)
            set.add(word);

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(begin + 0);
        visited.add(begin);
        
        while (!queue.isEmpty()) {
            String poll = queue.poll();

            char[] word = poll.substring(0, poll.length() - 1).toCharArray();
            int level = poll.charAt(poll.length() - 1) - '0';

            if (String.valueOf(word).equals(target)) 
                return level;
            
            for (int idx = 0; idx < word.length; idx++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = word[idx];
                    word[idx] = c;
                    String newWord = String.valueOf(word);
                    
                    if (set.contains(newWord) && !visited.contains(newWord)) {
                        queue.offer(newWord + (level + 1));
                        visited.add(newWord);
                    }
                    
                    word[idx] = temp;
                }
            }
        }
        
        return 0;
    }
}