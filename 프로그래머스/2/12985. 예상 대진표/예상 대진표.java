class Solution {
    public int solution(int n, int a, int b) {
        for(int round = 0;; round++) {
            if (a == b) return round;
            a = a % 2 == 1 ? a / 2 + 1: a / 2;
            b = b % 2 == 1 ? b / 2 + 1: b / 2;
        }
    }
}
/*
                1 2     3 4     5 6         7 8
                
2로 나누면       0 1     1 2     2 3          3 4
                1 0     1 0     1 0         1 0


        //a 에 더 작은 수 넣기
        int temp = a;
        a = a > b ? b : a;
        b = a == b ? temp : b;
*/