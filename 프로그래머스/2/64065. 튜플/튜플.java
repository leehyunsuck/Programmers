import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] split = s.split("}");
        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].replace("{", "").replace("}", "");
            if (split[i].charAt(0) == ',')
                split[i] = split[i].substring(1, split[i].length());
        }
        
        Arrays.sort(split, (s1, s2) -> s1.length() - s2.length());
        
        int[] answer = new int[split.length];
        Queue<Integer> cache = new LinkedList<>();
        
        for (int i = 0; i < answer.length; i++) {
            int putNum = 0;
            
            for (String sNum : split[i].split(",")) {
                try {
                    putNum = Integer.parseInt(sNum);
                } catch (Exception e) {
                    continue;
                }
                
                if (cache.contains(putNum)) continue;
                cache.add(putNum);
                break;
            }
            answer[i] = putNum;
        }
        
        return answer;
    }
}