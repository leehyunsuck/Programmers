class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int number = 2; number <= n; number++) {
            int temp = 0;
            for (int i = 1; i * i <= number && temp <= 2; i++)
                if (number % i == 0) temp += (number / i != i) ? 2 : 1;
            if (temp == 2) answer++;
        }
        
        return answer;
    }
}