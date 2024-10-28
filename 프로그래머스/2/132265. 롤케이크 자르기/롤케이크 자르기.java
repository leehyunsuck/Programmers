import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer>   first = new HashMap<>(),
                                second = new HashMap<>();
        
        for (int t : topping)
            second.put(t, second.getOrDefault(t, 0) + 1);
        
        for (int t : topping) {
            first.put(t, 1);        // 여기선 개수 굳이 안봐도 됨
            
            if (second.get(t) == 1) second.remove(t);
            else second.put(t, second.get(t) - 1);
            
            if (first.size() == second.size()) answer++;    // 이거 size 키 개수임
        }
        
        return answer;
    }
}
// 토핑의 종류의 개수만 다양하면 됨