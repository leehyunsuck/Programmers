import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> sizeCountMap = new HashMap<>();
        for (int size : tangerine) sizeCountMap.put(size, sizeCountMap.getOrDefault(size, 0) + 1);
        
        Queue<Integer> priQueue = new PriorityQueue<>(Collections.reverseOrder());
        priQueue.addAll(sizeCountMap.values());
        
        for(; k > 0; answer++) k -= priQueue.poll();
        
        return answer;
    }
}

/*
깡 배열 사용

        int answer = 0;
        
        int[] count = new int[10000001];
        for (int size : tangerine) count[size]++;
        
        Arrays.sort(count);
        
        for (int i = count.length - 1; k > 0; i--, answer++) k -= count[i];

        return answer;
        
테스트 1 〉	통과 (39.08ms, 135MB)
테스트 2 〉	통과 (42.80ms, 130MB)
테스트 3 〉	통과 (43.70ms, 128MB)
테스트 4 〉	통과 (36.44ms, 121MB)
테스트 5 〉	통과 (58.19ms, 134MB)
*/