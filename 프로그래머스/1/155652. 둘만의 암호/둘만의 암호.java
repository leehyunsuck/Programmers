import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        
        Map<Character, Boolean> passKey = new HashMap<>();
        
        for (int i = 0; i < skip.length(); i++) passKey.put(skip.charAt(i), false);
        
        StringBuilder answerBuilder = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char iChar = s.charAt(i);

            int idx = 0;
            while (idx < index) {
                iChar += 1;
                if (iChar > 'z') iChar = 'a';
                if (!passKey.containsKey(iChar)) idx++;
            }
            answerBuilder.append(iChar);
        }
        return answerBuilder.toString();
    }
}