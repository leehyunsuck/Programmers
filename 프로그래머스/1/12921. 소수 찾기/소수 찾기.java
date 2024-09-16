class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int number = 2; number <= n; number++) {
            int temp = 0;
            for (int i = 1; i * i <= number; i++) {
                if (number % i == 0) {
                    temp++;
                    if (number / i != i) temp++;
                }
                if (temp > 2) break;
            }
            if (temp == 2) answer++;
        }
        
        return answer;
    }
}