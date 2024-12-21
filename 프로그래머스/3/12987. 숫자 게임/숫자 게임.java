import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int bIdx = 0;
        for (int aNum : A) {
            while (bIdx < B.length && B[bIdx] <= aNum) bIdx++;
            if (bIdx >= B.length) break;
            answer++;
            bIdx++;
        }
        
        return answer;
    }
}

// N명씩 두팀으로 나누기
// A B 공수 , 큰 쪽이 1점 흭득
// B팀이 이길 수 있는 방식으로 배치하여, 가장 많이 얻는 점수

/*
시간초과
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        // 숫자 : 개수
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : B) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        
        for (int aNum : A) {
            int selectKey = 1_000_000_001,
                minKey    = 1_000_000_001;
            for (int key : map.keySet()) {
                if (key > aNum) selectKey = Math.min(selectKey, key);
                minKey = Math.min(minKey, key);
            }
            
            if (selectKey == 1_000_000_001) {
                valueSubOne(map, minKey);
                continue;
            }
            
            answer++;
            valueSubOne(map, selectKey);
        }
        
        return answer;
    }
    
    public void valueSubOne(Map<Integer, Integer> map, int key) {
        int numSubOne = map.get(key) - 1;
        if (numSubOne > 0) map.put(key, numSubOne);
        else map.remove(key);
    }
*/