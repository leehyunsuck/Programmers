import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int maxTime = 23 * 60 + 59;
        
        // [사용 시간 계산]  
        Map<String, Integer> infoMap = new HashMap<>();     // 차량 번호 : IN 시간   
        Map<String, Integer> usedTime = new HashMap<>();    // 차량 번호 : 사용 시간
        
        for (String record : records) {
            int     time    = Integer.parseInt(record.substring(0, 2)) * 60 +
                              Integer.parseInt(record.substring(3, 5));
            String  carNum  = record.substring(6, 10);
            char    type    = record.charAt(11);
            
            if (type == 'I') infoMap.put(carNum, time);
            else {
                usedTime.put(carNum , usedTime.getOrDefault(carNum, 0) + time - infoMap.get(carNum));
                infoMap.remove(carNum);
            }
        }
        for (String carNum : infoMap.keySet())
            usedTime.put(carNum, usedTime.getOrDefault(carNum, 0) + maxTime - infoMap.get(carNum));
        infoMap = null;
        
        // [사용 요금 계산]
        Map<String, Integer> priceMap = new TreeMap<>();    // 차량 번호 : 요금
        
        for (String carNum : usedTime.keySet()) {
            int price = fees[1],
                time  = usedTime.get(carNum);
            
            if (time > fees[0]) {
                time -= fees[0];
                
                int moreTime = time / fees[2];
                if (time % fees[2] != 0) moreTime++;
                
                price += fees[3] * moreTime;
            }
            priceMap.put(carNum, price);
        }
        usedTime = null;
        
        // [반환 값 생성]
        int[] answer = new int[priceMap.size()];
        int idx = 0;
        for (String carNum : priceMap.keySet())
            answer[idx++] = priceMap.get(carNum);
        
        return answer;
    }
}

// fees[0 ~ 3] 기본시간 , 기본요금 , 단위시간, 단위요금
// 나간 기록 없으면 23:59 에 나간걸로 간주
// 차량 번호 오름차순 기준으로 요금 return

// 5분 기준인데 6분이면 10분 요금