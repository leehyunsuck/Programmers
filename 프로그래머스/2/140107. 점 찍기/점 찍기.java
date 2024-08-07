class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for (long x = 0; x <= d; x += k) {
            //피타고라스로 y 최대 거리
            long yMax = (long) Math.sqrt((long) d * d - (long) x * x);
            
            //y 계수 계산 -> k 배수인 y개수
            answer += yMax / k + 1;
        }
        
        return answer;
    }
}

/*
[2 ,4]
    0   1   2   3   4
0   *       *       *
1   
2   *       *
3
4   *

피타고라스

x 0 ~ 4(d) 까지 반복
y최대 = SQRT(4*4 - x*x)
y최대 / 2(k)

10 / 2 = 5 
2 4 6 8 10

0 좌표도 추가해야 하니까 + 1


*/