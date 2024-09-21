import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0,
            wallet = budget;
        
        Arrays.sort(d);
        for (int i = 0; i < d.length; i++, answer++) {
            wallet -= d[i];
            if (wallet < 0) break;
        }
        
        return answer;
    }
}