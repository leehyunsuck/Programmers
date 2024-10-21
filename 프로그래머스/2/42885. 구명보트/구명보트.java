import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0,
            left = 0,
            right = people.length - 1;
        
        for (; left <= right; answer++, right--) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
        }
        
        return answer;
    }
}