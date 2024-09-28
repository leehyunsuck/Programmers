import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
    
        boolean upper = true;
        for (char c : s.toLowerCase().toCharArray()) {
            answer.append(upper ? Character.toUpperCase(c) : c);
            upper = c == ' ' ? true : false;
        }
    
        return answer.toString();
    }
}