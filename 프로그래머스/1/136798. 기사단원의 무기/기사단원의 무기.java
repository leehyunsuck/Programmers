class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        // 1 ~ number 까지 약수 구해야함
        for (int i = 1; i <= number; i++) {
            
            // 약수 구하기
            int count = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) count++;
                else if (i % j == 0) count += 2;
            }
            
            // limit 확인 후 필요 철 무게 합 계산
            answer += count > limit ? power : count;
        }
        
        return answer;
    }
}