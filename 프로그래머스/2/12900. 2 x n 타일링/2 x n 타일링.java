class Solution {
    public int solution(int n) {
        if (n <= 2) return n;
        
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        
        for (int idx = 3; idx < dp.length; idx++)
            dp[idx] = (dp[idx - 1] + dp[idx - 2]) % 1000000007;
        
        return dp[n];
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