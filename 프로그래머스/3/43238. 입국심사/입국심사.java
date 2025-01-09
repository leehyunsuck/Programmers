import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long answer = (long) times[times.length - 1],
             min = 1L,
             max = 1_000_000_000L * n;
        
        while (min <= max) {
            long mid = (min + max) / 2,
                 pass = 0;
            
            for (int time : times)
                pass += mid / time;
            
            if (pass < n) {
                min = mid + 1;
                continue;
            }
            answer = mid;
            max = mid - 1;
        }
        
        return answer;
    }
}