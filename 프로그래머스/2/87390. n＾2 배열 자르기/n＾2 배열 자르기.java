class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        
        try {
            boolean first = true;
            int start = (int) (left % (long) n) + 1;
            for (int i = (int) (left / (long) n) + 1, realIdx = 0; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (first) {
                        j = start;
                        first = false;
                    }
                    answer[realIdx++] = Math.max(i, j);
                }
            }
        } catch (Exception e) {
            // 비교 연산 시간 줄이기
        }
        
        
        return answer;
    }
}

/*

1 2 3 4
2 2 3 [4
(3 3 3 4)
4 4 4] 4

7 ~ 14
4 3 3 3 4 4 4 4

8 ~ 11
3 3 3 4

16 - 0 = 16         16 - 3 = 13         0 ~ 3
16 - 4 = 12         16 - 7 = 9          4 ~ 7
16 - 8 = 8          16 - 11= 5          8 ~ 11
16 - 12 = 4         16 - 15= 1          12 ~ 15

left / n =  0 + 1   = 1
            1 + 1   = 2
            2 + 1   = 3
            3 + 1   = 4

left % n
    0 ~ 3       7 % 4   = 3
                8 % 4   = 0

*/