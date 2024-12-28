class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1)
            return sticker[0];
        
        return Math.max(dynamicProgramming(sticker, 2), dynamicProgramming(sticker, 1));
    }
    
    public int dynamicProgramming(int[] sticker, int option) {
        int[] dp = new int[sticker.length];
        
        if (option == 2) {
            dp[0] = sticker[0];
            dp[1] = dp[0];
        } else {
            dp[0] = 0;
            dp[1] = sticker[1];
        }
        for (int i = 2; i < sticker.length - option + 1; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        
        
        return dp[sticker.length - option];
    }
} 