import java.util.*;
import java.util.function.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        List<Integer> answerList = new ArrayList<>();
        
        Map<Character, Integer> expMap = new HashMap<>();
        
        BiFunction<String, Integer, String> addStr = (str, num) -> String.valueOf(Integer.parseInt(str) + num);
        BiFunction<String, Integer, String> subStr = (str, num) -> {
            String result = String.valueOf(Integer.parseInt(str) - num);
            if (result.length() == 1) result = "0" + result;
            return result;
        };

        String[] todaySplit = today.split("\\.");
           
        for (String term : terms) {
            //[0] 약관 종류, [1] 약관 기간
            String[] termSplit = term.split(" ");
            expMap.put(termSplit[0].charAt(0), Integer.parseInt(termSplit[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            //[0] 수락 날짜, [1] 약관 종류 
            String[] priSplit = privacies[i].split(" ");
            int expTerm = expMap.get(priSplit[1].charAt(0));
            
            // 유효 기간
            String[] date = priSplit[0].split("\\.");

            date[1] = addStr.apply(date[1], expTerm);
            while (Integer.parseInt(date[1]) > 12) {
                date[0] = addStr.apply(date[0], 1);
                date[1] = subStr.apply(date[1], 12);
            }

            date[2] = subStr.apply(date[2], 1);
            if (Integer.parseInt(date[2]) <= 0) {
                date[1] = subStr.apply(date[1], 1);
                date[2] = "28";
            }


            //년도가 파기날짜보다 큼
            if (Integer.parseInt(date[0]) > Integer.parseInt(todaySplit[0])) continue;
            
            //년도가 같지만 월이 파기날짜보다 큼
            if (Integer.parseInt(date[0]) == Integer.parseInt(todaySplit[0]) && 
                Integer.parseInt(date[1]) > Integer.parseInt(todaySplit[1])) continue;
            
            //년도와 월이 같지만 일이 파기 날짜보다 크거나 같음
            if (Integer.parseInt(date[0]) == Integer.parseInt(todaySplit[0]) && 
                Integer.parseInt(date[1]) == Integer.parseInt(todaySplit[1]) && 
                Integer.parseInt(date[2]) >= Integer.parseInt(todaySplit[2])) continue;

            answerList.add(i+1);
        }
        
        int[] answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

// 모든 달은 28일까지 있다 가정