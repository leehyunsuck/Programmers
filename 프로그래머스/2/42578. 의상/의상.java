import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] info : clothes) 
            clothesMap.put(info[1], clothesMap.getOrDefault(info[1], 0) + 1);
        
        for (int count : clothesMap.values())   
            answer *= count + 1;

        return --answer;    // 전체 안입은 경우 빼기
    }
}