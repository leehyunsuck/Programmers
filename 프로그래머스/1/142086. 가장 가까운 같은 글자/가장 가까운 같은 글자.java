import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> charIdxMap = new HashMap<>();
        
        int answer[] = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char findChar = s.charAt(i);
            int putAnswer;
            
            if (charIdxMap.containsKey(findChar)) putAnswer = i - charIdxMap.get(findChar);
            else putAnswer = -1;
            
            charIdxMap.put(findChar, i);
            answer[i] = putAnswer;
        }
        
        return answer;
    }
}