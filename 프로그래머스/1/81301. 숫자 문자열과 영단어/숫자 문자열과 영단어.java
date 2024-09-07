import java.util.*;

class Solution {
    public int solution(String s) {
        Map<String, String> engNumMap = new HashMap<>();
        String[] eng = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < 10; i++) engNumMap.put(eng[i], String.valueOf(i));

        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c >= '0' && c <= '9') answer.append(c);
            else temp.append(c);
            
            if (engNumMap.containsKey(temp.toString())) {
                answer.append(engNumMap.get(temp.toString()));
                temp = new StringBuilder();
            }
        }

        return Integer.parseInt(answer.toString());
    }
}