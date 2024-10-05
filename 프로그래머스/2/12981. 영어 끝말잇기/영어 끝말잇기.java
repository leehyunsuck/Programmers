import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> save = new HashSet<>();
        save.add(words[0]);
        
        int[] answer = new int[] {2, 1};
        char lastChar = words[0].charAt(words[0].length() - 1);
        for (int i = 1; i < words.length; i++, answer[0]++) {
            if (answer[0] > n) {
                answer[0] = 1;
                answer[1]++;
            }
            if (words[i].charAt(0) != lastChar || !save.add(words[i])) return answer;
            lastChar = words[i].charAt(words[i].length() - 1);
        }
        
        return new int[] {0, 0};
    }
}