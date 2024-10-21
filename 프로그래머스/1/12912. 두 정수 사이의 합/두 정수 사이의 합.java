class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int minNum = a,
            maxNum = b;
        
        if (minNum > maxNum) {
            minNum = b;
            maxNum = a;
        }
        
        while (minNum <= maxNum) 
            answer += minNum++;
        
        return answer;
    }
}