import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                answer.append(c);
                continue;
            }
            
            char append = (char) (c + n);
            if ((c >= 97 && c <= 122 && append > 122) || (c >= 65 && c <= 90 && append > 90)) append -= 26;
            
            answer.append(append);
        }
        
        return answer.toString();
    }
}