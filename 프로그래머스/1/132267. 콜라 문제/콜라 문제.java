class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while (n >= a) {
            int get = n / a * b;
            n = n % a + get;
            answer += get;
        }
        
        return answer;
    }
}

// a개를 가져다 주면 b개를 줌
// 나에게는 n개 있음