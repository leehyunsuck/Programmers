class Solution {
    public int solution(int[] sticker) {
        if (sticker.length == 1)
            return sticker[0];
        
        return Math.max(dynamicProgramming(sticker, true), dynamicProgramming(sticker, false));
    }
    
    public int dynamicProgramming(int[] sticker, boolean first) {
        int[] dp = new int[sticker.length];
        
        dp[0] = first ? sticker[0] : 0;
        dp[1] = first ? dp[0] : sticker[1];
 
        int option = first ? 1 : 0;
        for (int i = 2; i < sticker.length - option; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + sticker[i]);
        
        
        return dp[sticker.length - 1 - option];
    }
} 