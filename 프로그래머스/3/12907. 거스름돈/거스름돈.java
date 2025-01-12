class Solution {
    public int solution(int n, int[] moneys) {
        int[] caseDP = new int[n + 1];
        caseDP[0] = 1;
        
        for (int money : moneys) {
            for (int i = money; i <= n; i++) {
                caseDP[i] = (caseDP[i] + caseDP[i - money]) % 1_000_000_007;
            }
        }
        
        return caseDP[n];
    }
}