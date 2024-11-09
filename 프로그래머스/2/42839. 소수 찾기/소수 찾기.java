import java.util.*;

class Solution {
    // Key : Value = 숫자 : 소수인지 아닌지
    private Map<Integer, Boolean> primeInfo = new HashMap<>();
    
    public int solution(String numbers) {
        Set<Integer> answerSet = new HashSet<>();       // 소수 저장 (겹치면 안되니까 Set사용)
        
        boolean[] used = new boolean[numbers.length()]; // DFS에서 특정 칸 사용 여부 확인용
        this.dfs(numbers, 0, used, answerSet);
        
        return answerSet.size();                        // 소수 개수 Return
    }
    
    // 탐색
    public void dfs(String numbers, int result, boolean[] used, Set<Integer> answerSet) {
        if (result != 0 && this.isPrime(result))        // 0이 아니고 -> 초기값 0으로 줌
            answerSet.add(result);                      // + 소수이면 set에 추가
        
        for (int i = 0; i < numbers.length(); i++) {    
            if (used[i]) continue;                      // 이미 사용한 인덱스위치의 값은 사용하면 안됨
            
            used[i] = true;                             // 사용했다고 설정
            
            /*
            [흐름] ex) 17
            
            [처음 도착 (for 반복문)]
            dfs(17, 1, used, answerSet);            1   -> 소수 아님
                -> dfs(17, 17, used, answerSet);    17  -> 소수임
            dfs(17, 7, used, answerSet);            7   -> 소수임
                -> dfs(17, 71, used, answerSet);    71  -> 소수임
            */
            dfs(numbers, result * 10 + (numbers.charAt(i) - '0'), used, answerSet);
            
            used[i] = false;                            // 다른 조합도 만들어야하므로 안했다고 다시 설정
        }
    }

    // 소수 판별 
    public boolean isPrime(int num) {
        // 이미 저장된 데이터면 꺼내서 쓰기
        if (primeInfo.containsKey(num))
            return primeInfo.get(num);
        
        // 약수 개수 확인
        int count = 0;
        for (int i = 1; i * i <= num && count <= 2; i++) {
            if (num % i != 0) continue;
            count++;
            if (num / i != i) count++;
        }
        
        // 정보 저장
        if (count == 2) primeInfo.put(num, true);
        else primeInfo.put(num, false);
        
        return count == 2;
    }
}