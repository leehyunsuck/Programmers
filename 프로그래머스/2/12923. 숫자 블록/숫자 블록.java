class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end - begin) + 1];
        
        for (int idx = 0; idx < answer.length; idx++)
            answer[idx] = getMaxDiv(idx + begin);
        
        return answer;
    }
    
    private int getMaxDiv(long value) {
        if (value == 1) return 0;
        
        int result = 1;
        for (long i = 2; i * i <= value; i++) {
            if (value % i != 0) continue;
            long j = value / i;
            if (j <= 10_000_000) return (int) j;
            result = (int) i;
        }
        return result;
    }
}

// 가장 큰 약수