import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0,
            saleTerm = 10;

        // 물품 : {날짜, 날짜}
        Map<String, List<Integer>> discountMap = new HashMap<>();
        
        // Map 데이터 추가
        for (int i = 0; i < discount.length; i++) {
            String item = discount[i];
            discountMap.putIfAbsent(item, new ArrayList<>());
            discountMap.get(item).add(i + 1);
        }
        
        // 1일차부터 마지막날까지 반복
        for (int day = 1; day <= discount.length; day++) {
            boolean check = true;
            for (int idx = 0; idx < want.length && check; idx++) {
                String wantItem = want[idx];
                int wantCount = number[idx],
                    lastDay = day + saleTerm - 1;

                // 세일에 없는 물품
                if (!discountMap.containsKey(wantItem)) return 0;
                    
                List<Integer> discountDay = discountMap.get(wantItem);
                for (int discountTerm : discountDay) {
                    if (discountTerm >= day && discountTerm <= lastDay) wantCount--;
                    else if (discountTerm > lastDay) break;
                }
                
                if (wantCount > 0) check = false;
            }
            if (check) answer++;
        }
       
        return answer;
    }
}