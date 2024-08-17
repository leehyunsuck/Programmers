import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Map<Character, Integer> saveMap = new HashMap<>();
        
        char startChar = 'S';   // 소문자만 들어있으니 대문자로 구분
        
        for (int idx = 0; idx < s.length(); idx++) {
            char idxValueOfS = s.charAt(idx);
            int putCount;
            
            if (startChar == 'S') startChar = idxValueOfS;
            
            if (saveMap.containsKey(idxValueOfS)) putCount = saveMap.get(idxValueOfS) + 1;
            else if (saveMap.containsKey('O')) putCount = saveMap.get('O') + 1;     // Other
            else putCount = 1;
            
            if (saveMap.containsValue(putCount)) {
                saveMap = new HashMap<>();
                startChar = 'S';
                answer++;
            } else {
                if (startChar == idxValueOfS) saveMap.put(idxValueOfS, putCount);
                else saveMap.put('O', putCount);
            }

            if (idx == s.length() - 1 && !saveMap.isEmpty()) answer++;
        }
        
        return answer;
    }
}
