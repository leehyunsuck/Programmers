import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int len = 1, maxLen = s.length() / 2; len <= maxLen; len++) {
            int strLen = 0;
            
            String nowWord = s.substring(0, len);
            int count = 1;
            
            for (int i = len; i < s.length(); i += len) {
                String nextWord = s.substring(i, Math.min(i + len, s.length()));
                
                if (nowWord.equals(nextWord)) {
                    count++;
                    continue;
                }
                
                strLen += count > 1 ? len + String.valueOf(count).length() : len;
                nowWord = nextWord;
                count = 1;
            }
            strLen += count > 1 ? len + String.valueOf(count).length() : nowWord.length();
            
            answer = Math.min(answer, strLen);
        }
        
        return answer;
    }
}