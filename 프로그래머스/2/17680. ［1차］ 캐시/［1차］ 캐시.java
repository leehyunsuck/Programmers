import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> cache = new LinkedList<>();
        
        if (cacheSize == 0) 
            return 5 * cities.length;
        
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            
            if (cache.size() > 0 && cache.contains(city)) {
                answer++;
                cache.remove(city);    // 다시 위에 넣을거임
            } else {
                answer += 5;
                
                if (cache.size() == cacheSize)
                    cache.remove();
            }
            cache.add(city);
        }
        
        return answer;
    }
}

// 캐시에 있으면 1초, 없으면 5초