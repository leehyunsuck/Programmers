class Solution {
    public long solution(int k, long d) {
        long answer = 0;
        
        //x의 좌표를 k 배수로 증가 반복
        for (long x = 0; x <= d; x += k) 
            // y^2 = d^2 - x^2  , (y^2 / k) + 1 (원점)          
            answer += ((long) Math.sqrt(d * d - x * x)) / k + 1;

        return answer;
    }
}


/*
피타고라스

x^2 + y^2 <= d^2

d^2 - x^2 = y^2

x = 0 2 4 , d = 4
y = sqrt(16, 12, 0) 4, 3.??, 0

2 + 1   3
1 + 1   2
0 + 1   1
        6

*/