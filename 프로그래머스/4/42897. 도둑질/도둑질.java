class Solution {
    public int solution(int[] money) {  
        return Math.max(lastValueDP(money, 0, money.length - 2), 
                        lastValueDP(money, 1, money.length - 1));
    }
    
    private int lastValueDP(int[] arr, int start, int end) {
        int[] dp = new int[arr.length + 1];
        dp[start]     = arr[start];
        dp[start + 1] = Math.max(dp[start], arr[start + 1]);
        
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i]);
        }
        
        return dp[end];
    }
}