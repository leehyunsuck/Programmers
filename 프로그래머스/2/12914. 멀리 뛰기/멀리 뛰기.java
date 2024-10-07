class Solution {
    public long solution(int n) {
        long    answer = 1,
                tempSave = 1;
        
        for (int i = 1; i < n; i++) {
            long sum = answer + tempSave;
            if (sum >= 1234567) sum %= 1234567;
            tempSave = answer;
            answer = sum;
        }
        
        return answer;
    }
}
