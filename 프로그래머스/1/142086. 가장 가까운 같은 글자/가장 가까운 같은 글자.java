import java.util.*;

class Solution {
    public int[] solution(String s) {
        Map<Character, Integer> charIdxMap = new HashMap<>();
        
        List<Integer> answerList = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            char findChar = s.charAt(i);
            int putAnswer;
            
            if (charIdxMap.containsKey(findChar)) putAnswer = i - charIdxMap.get(findChar);
            else putAnswer = -1;
            
            charIdxMap.put(findChar, i);
            answerList.add(putAnswer);
        }
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}