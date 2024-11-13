class Solution {
    public int[] solution(int n, int m) {
        // 최대_공약수, 최소_공배수 두개 return 해야하므로 int[2]
        int[] answer = new int[2];
        
        // n, m 둘 중 어느게 작은값일지 모르므로 판별
        int small = n < m ? n : m,
            big   = small != n ? n : m;

        // 최대 공약수 구하기   -> 두 수의 공통된 약수 중 가장 큰 약수
        for (int i = small; i >= 1; i--) {  // 1 ~ 작은수까지 반복해서 나눠볼거임
            if (n % i != 0) continue;   // n이 i로 나눠지지 않으면 약수 아님
            if (m % i != 0) continue;   // m이 i로 나눠지지 않으면 약수 아님
            
            // n, m 둘 다 나눌 수 있는 약수는 넘어올 수 있음
            answer[0] = i;
            break;
        }
        
        
        // 최소 공배수 구하기   -> 두 수의 배수 중 공통된 배수인 가장 작은 수
        for (int i = small; i <= n * m; i += small) {   // 가장 작은수부터 시작하고, 가장 작은 수를 배수하며 시작
            if (i % big != 0) continue;     // 작은수의 배수가 큰 수로 나누어 떨어지지 않으면 큰 수의 배수가 아님
            
            // 작은수의 배수(i) 가 큰 수로 나누어 떨어져야 이곳에 올 수 있음
            answer[1] = i;
            break;
        }
        
        return answer;
    }
}