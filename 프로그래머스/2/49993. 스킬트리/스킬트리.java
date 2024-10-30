import java.util.*;

class Solution {
    public int solution(String skill, String[] skillTrees) {

        Map<Character, Integer> sequenceMap = new HashMap<>();
        
        Integer sequence = 0;
        for (char c : skill.toCharArray())
            sequenceMap.put(c, sequence++);

        int answer = 0;
        
        for (String skillTree : skillTrees) {
            sequence = 0;
            boolean checkSum = true;
            
            for (char c : skillTree.toCharArray()) {
                if (!checkSum) break;
                if (!sequenceMap.containsKey(c)) continue;
                if (sequenceMap.get(c) != sequence) checkSum = false;
                sequence++;
            }
            
            if (checkSum) answer++;
        }
        return answer;
    }
}