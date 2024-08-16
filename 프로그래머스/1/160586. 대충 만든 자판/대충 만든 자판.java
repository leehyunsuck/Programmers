import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> clickCount = new HashMap<>();
        
        for (int keyIdx = 0; keyIdx < keymap.length; keyIdx++) {
            for (int charIdx = 0; charIdx < keymap[keyIdx].length(); charIdx++) {
                char putChar = keymap[keyIdx].charAt(charIdx);

                if (clickCount.containsKey(putChar)) {
                    int getCount = clickCount.get(putChar);
                    if (charIdx >= getCount) continue;
                }
                clickCount.put(putChar, charIdx);
            }
        }
        
        for (int targetIdx = 0; targetIdx < targets.length; targetIdx++) {
            for (int charIdx = 0; charIdx < targets[targetIdx].length(); charIdx++) {
                char getChar = targets[targetIdx].charAt(charIdx);
                
                if (!clickCount.containsKey(getChar)) {
                    answer[targetIdx] = -1;
                    break;
                }
                
                int getCount = clickCount.get(getChar);
                answer[targetIdx] += getCount+1;
            }
        }
        

        return answer;
    }
}
