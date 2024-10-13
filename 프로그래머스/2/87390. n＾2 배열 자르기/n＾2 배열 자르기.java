class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        
        // 종료 조건 없이 배열값 넘어가면 종료
        try {
            int startI = (int) (left / (long) n) + 1,
                startJ = (int) (left % (long) n) + 1,
                index = 0;
            
            for (int j = startJ; j <= n; j++, index++)
                answer[index] = Math.max(startI, j);
            
            for (int i = startI + 1; i <= n; i++) {
                for (int j = 1; j <= n; j++, index++) 
                    answer[index] = Math.max(i, j);
            }
        } catch (Exception e) { }
        
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


초기 코드
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
*/