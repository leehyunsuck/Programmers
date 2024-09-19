import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (s1, s2) -> {
            String  c1 = s1.charAt(n) + "",
                    c2 = s2.charAt(n) + "";
            
            if (c1.equals(c2)) return s1.compareTo(s2);
            return c1.compareTo(c2);
        });
        
        return strings;
    }
}