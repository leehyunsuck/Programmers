import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 캐쉬 사이즈 없으면 모든 요청 실행시간이 5임
        if (cacheSize == 0) 
            return 5 * cities.length;
        
        Queue<String> cache = new LinkedList<>();
        Map<String, Byte> haveMap = new HashMap<>();
        
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase(); 
            
            if (haveMap.containsKey(city)) {
                answer++;
                cache.remove(city);
            } else {
                answer += 5;
                if (cache.size() == cacheSize) {
                    String removeCity = cache.remove();
                    haveMap.remove(removeCity);
                }
            }
            cache.add(city);
            haveMap.put(city, (byte) 0);
        }
        
        return answer;
    }
}


// 메모리: 123 MB, 시간: 39.26 ms