class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        boolean[][] puddle = new boolean[m][n];
        for (int[] p : puddles)
            puddle[p[0] - 1][p[1] - 1] = true;
        
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (puddle[row][col]) dp[row][col] = 0;
                else {
                    if (row > 0) dp[row][col] += dp[row-1][col];
                    if (col > 0) dp[row][col] += dp[row][col-1];
                    dp[row][col] %= 1_000_000_007;
                }
            }
        }
        
        return dp[m-1][n-1];
    }
}

// 우, 하로만 움직일 수 있음