import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (str1, str2) -> {
            char c1 = str1.charAt(n),
                 c2 = str2.charAt(n);
            
            int compare = c1 - c2;
            if (compare != 0) return compare;
            
            return str1.compareTo(str2);
        });
       
        return strings;
    }
}