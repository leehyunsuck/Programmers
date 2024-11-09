import java.util.*;

class Solution {
    // 소수 판별 여부 저장
    private Map<Integer, Boolean> primeInfo = new HashMap<>();
    
    public int solution(String numbers) {
        Set<Integer> answerSet = new HashSet<>();
        boolean[] used = new boolean[numbers.length()];
        
        this.dfs(numbers, 0, used, answerSet);
        
        return answerSet.size();
    }
    
    // 탐색
    public void dfs(String numbers, int result, boolean[] used, Set<Integer> answerSet) {
        if (result != 0) {
            if (this.isPrime(result))
                answerSet.add(result);
        }
        
        for (int i = 0; i < numbers.length(); i++) {
            if (used[i]) continue;
            
            used[i] = true;
            dfs(numbers, result * 10 + (numbers.charAt(i) - '0'), used, answerSet);
            used[i] = false;
        }
    }
    
    // 소수 판별 및 숫자 정보 저장
    public boolean isPrime(int num) {
        if (primeInfo.containsKey(num))
            return primeInfo.get(num);
        
        int count = 0;
        for (int i = 1; i * i <= num && count <= 2; i++) {
            if (num % i != 0) continue;
            count++;
            if (num / i != i) count++;
        }
        
        if (count == 2) primeInfo.put(num, true);
        else primeInfo.put(num, false);
        
        return count == 2;
    }
}