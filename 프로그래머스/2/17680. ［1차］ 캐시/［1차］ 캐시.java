import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        // 캐쉬 사이즈 없으면 모든 요청 실행시간이 5임
        if (cacheSize == 0) 
            return 5 * cities.length;
        
        Queue<String> cache = new LinkedList<>();
        
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase(); 
            
            // 캐쉬에 해당 값이 있음
            if (cache.size() > 0 && cache.contains(city)) {
                answer++;
                cache.remove(city);    // 사용했으니 다시 위에 넣기 위해 제거
            } else {
                answer += 5;
                
                if (cache.size() == cacheSize) cache.remove();
            }
            cache.add(city);
        }
        
        return answer;
    }
}