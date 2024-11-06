class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < answer.length; i++) {
            long number = numbers[i];
            
            // 짝수면 2^0 자리 무조건 0임
            if (number % 2 == 0) {
                answer[i] = number + 1;
                continue;
            }
            
            // 0 있는 위치 찾기
            long bit = 1;
            while ( (number & bit) != 0) 
                bit <<= 1;

            answer[i] = number + bit - (bit >>= 1);
        }
        return answer;
    }
}

/*
23  10111   ->  11011
    
    


*/