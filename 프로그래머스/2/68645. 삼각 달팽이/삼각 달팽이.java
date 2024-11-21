class Solution {
    private int[][] moveInfo = {
        {1, 0},     // 위로       (이미지에선 아래로)
        {0, 1},     // 오른쪽으로
        {-1, -1}    // 대각선으로
    };
    
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        
        int moveIdx = 0,    value  = 1,
            row     = 0,    column = 0;
        
        while (moveIdx < n) {
            triangle[row][column] = value++;
            
            // 다음 놓을 위치 확인
            int checkRow    = row    + moveInfo[moveIdx % 3][0],
                checkColumn = column + moveInfo[moveIdx % 3][1];
            
            if (checkRow >= triangle.length || checkRow < 0                     // row 배열 넘어감
                || checkColumn >= triangle[checkRow].length || checkColumn < 0  // column 배열 넘어감
                || triangle[checkRow][checkColumn] != 0) {                      // 값 들어가있음
                moveIdx++;
            }
            
            row    += moveInfo[moveIdx % 3][0];
            column += moveInfo[moveIdx % 3][1];
        }
        
        int[] answer = new int[value - 1];
        int answerIdx = 0;
        for (int[] tri : triangle) {
            for (int t : tri) {
                if (t == 0) break;
                answer[answerIdx++] = t;
            }
        }
        
        return answer;
    }
}