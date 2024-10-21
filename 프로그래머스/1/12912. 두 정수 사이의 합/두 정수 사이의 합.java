class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int temp = a;
        a = a < b ? a : b;
        b = a < b ? b : temp;
        
        for (; a <= b; a++)
            answer += a;
        
        return answer;
    }
}