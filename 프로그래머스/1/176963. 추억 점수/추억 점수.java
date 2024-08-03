import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        Map<String, Integer> nameScore = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) nameScore.put(name[i], yearning[i]);
        
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String people : photo[i]) score += nameScore.containsKey(people) ? nameScore.get(people) : 0;
            answer[i] = score;
        }

        return answer;
    }
}