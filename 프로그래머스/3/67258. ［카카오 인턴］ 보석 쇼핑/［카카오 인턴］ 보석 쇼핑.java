import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[] {1, gems.length};
        
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) gemSet.add(gem);
        
        Map<String, Integer> gemMap = new HashMap<>(); // gemName : count
        
        int[] pointer = new int[] {0, 0};   // {startPoint, endPoint}
        while (pointer[1] < gems.length) {
            gemMap.put(gems[pointer[1]], gemMap.getOrDefault(gems[pointer[1]++], 0) + 1);
            
            while (gemMap.size() == gemSet.size()) {
                if (answer[1] - answer[0] > pointer[1] - pointer[0] - 1) {
                    answer[0] = pointer[0] + 1;
                    answer[1] = pointer[1];
                }
                
                String startGemName = gems[pointer[0]++];
                int startGemCount   = gemMap.get(startGemName);
                
                if (startGemCount <= 1) gemMap.remove(startGemName);
                else gemMap.put(startGemName, startGemCount - 1);
            }
        }
        
        return answer;
    }
}