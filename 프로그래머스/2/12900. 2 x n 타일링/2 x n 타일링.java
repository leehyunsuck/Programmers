class Solution {
    public int solution(int n) {
        if (n <= 2) return n;
        
        int answer = 2,
            min = 1;
        
        for (int i = 3; i < n + 1; i++) {
            int temp = answer;
            answer = (answer + min) % 1_000_000_007;
            min = temp;
        }

        return answer;
    }
}

// 타일 : 가로 2, 세로 1

/*
0 = 0
1 = | = 1
2 = || -- = 2
3 = ||| |_ _| = 3
4 = |||| ____ ||_ |_| _|| = 5


*/