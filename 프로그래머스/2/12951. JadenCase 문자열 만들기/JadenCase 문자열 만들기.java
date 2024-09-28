import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
    
        boolean upper = true;
        for (char c : s.toCharArray()) {
            if (c == ' ') upper = true;
            else if (upper) {
                if (!(c <= '9')) c = Character.toUpperCase(c);
                upper = false;
            } else c = Character.toLowerCase(c);
            answer.append(c);
        }
    
        return answer.toString();
    }
}