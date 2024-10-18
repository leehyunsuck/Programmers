class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i * i <= n; i++) {
            if (n % i != 0) continue;
            answer += i;
            if (n / i != i) answer += n / i;
        }
        
        return answer;
    }
}