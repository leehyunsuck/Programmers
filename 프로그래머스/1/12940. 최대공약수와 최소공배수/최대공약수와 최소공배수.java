class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        int min = n < m ? n : m,
            max = min == n ? m : n;
        
        for (int i = 1; i <= min; i++)
            if (min % i == 0 && max % i == 0) answer[0] = i;
        
        for (int i = min; i <= min * max; i += min)
            if (i % max == 0) {
                answer[1] = i;
                break;
            }
        
        return answer;
    }
}