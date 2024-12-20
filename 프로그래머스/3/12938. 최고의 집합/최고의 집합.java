class Solution {
    public int[] solution(int n, int s) {
        if (s < n) return new int[] {-1};
        
        int[] answer = new int[n];

        // 균등하게 분배
        for (int idx = 0, offer = s / n; idx < n; idx++) 
            answer[idx] = offer;   
        
        // 남은 값들은 맨 뒤에서 순차적으로
        for (int i = 0; i < s % n; i++)
            answer[n - 1 - i]++;
        
        return answer;
    }
}

// s = 9

// k = 2
// 4 5(20), 3 6(18), 2 7(14), 1 8(8)

// k = 3
// 3 3 3(27), 2 3 4(24), 2 2 5,

// k = 4
// 2 2 2 3(24), 1 2 2 4(16), 1 2 3 3(18)