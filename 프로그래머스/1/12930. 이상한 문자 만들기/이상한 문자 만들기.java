import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0, check = 0; i < s.length(); i++, check++) {
            if (s.charAt(i) == ' ') {
                answer.append(' ');
                check = -1;
                continue;
            }
            answer.append(check % 2 == 0 ? (s.charAt(i)+"").toUpperCase() : (s.charAt(i)+"").toLowerCase());
            
        }
     
        return answer.toString();
    }
}