import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        // 성격 추가시 짝 맞춰 유형만 추가하면 됨
        Map<Character, Integer> scoreMap = new LinkedHashMap<>(){{
            put('R', 0); put('T', 0);
            put('C', 0); put('F', 0);
            put('J', 0); put('M', 0);
            put('A', 0); put('N', 0);
        }};
        
        // 점수 반영
        for (int i = 0; i < survey.length; i++) {
            int checkNum = choices[i];
            
            if (checkNum == 4) continue;
            
            if (checkNum < 4) {
                char key = survey[i].charAt(0);
                scoreMap.put(key, scoreMap.get(key) + 4 - checkNum);
            } else {
                char key = survey[i].charAt(1);
                scoreMap.put(key, scoreMap.get(key) + checkNum - 4);
            }
        }
        
        // 점수 더 큰 성격유형 확인 (나중에 성격 추가하면 건들 필요 없게끔)
        StringBuilder answerBuilder = new StringBuilder();
        
        int count = 1;
        
        char firChar = ' ';
        int firInt = '0'; 
        for (Map.Entry<Character, Integer> entry : scoreMap.entrySet()) {
            // 2개씩 비교하기 위해
            if (count % 2 == 0) {
                char secChar = entry.getKey();
                int secInt = entry.getValue();
                
                char addChar;
                
                if (firInt > secInt) addChar = firChar;
                else if (firInt < secInt) addChar = secChar;
                else addChar = firChar < secChar ? firChar : secChar;
                
                answerBuilder.append(addChar);
            } else {
                firChar = entry.getKey();
                firInt = entry.getValue();
            }
            count++;
        }
        
        return answerBuilder.toString();
    }
}

/*
R|T  /  C|F  /  J|M  /  A|N

[L] 3 2 1 0 1 2 3 [R]
    1 2 3 4 5 6 7
    
점수 더 높은것으로 결정
동일시 사전순
*/