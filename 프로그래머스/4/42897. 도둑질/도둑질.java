class Solution {
    public int solution(int[] money) {
        int firstStart  = steal(money, 0, money.length - 2),
            secondStart = steal(money, 1, money.length - 1);
        
        return Math.max(firstStart, secondStart);
    }
    
    private int steal(int[] money, int start, int end) {
        int[] dp = new int[money.length + 1];
        dp[start] = money[start];
        dp[start + 1] = Math.max(money[start], money[start + 1]);
        
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
        }
        
        return dp[end];
    }
}