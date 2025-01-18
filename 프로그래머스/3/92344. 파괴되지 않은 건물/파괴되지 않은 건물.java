class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length,
            m = board[0].length;
        
        int[][] prefixSum = new int[n + 1][m + 1];
        
        for (int[] info : skill) {
            int sRow = info[1], sCol = info[2],
                eRow = info[3], eCol = info[4],
                health = info[0] == 1 ? -1 * info[5] : info[5];
            
            prefixSum[sRow][sCol] += health;            // 구간합 시작
            prefixSum[sRow][eCol + 1] -= health;        // 가로 구간합 끝나는 지점
            prefixSum[eRow + 1][sCol] -= health;        // 세로 구간합 끝나는 지점
            prefixSum[eRow + 1][eCol + 1] += health;    // 끝나는 지점 겹치는 부분 중복
            
            /*
            위 코드에서 '+1' 을 왜 하냐?
                - 그 부분까진 수치가 반영되야하고, 다음부분 부터 반영되면 안되니까
            */
        }
        
        // 가로줄 누적합
        for (int row = 0; row < n; row++)
            for (int col = 1; col < m; col++)
                prefixSum[row][col] += prefixSum[row][col - 1];
        // 세로줄 누적합
        for (int row = 1; row < n; row++)
            for (int col = 0; col < m; col++)
                prefixSum[row][col] += prefixSum[row - 1][col];

        
        int answer = 0;
        for (int row = 0; row < n; row++)
            for (int col = 0; col < m; col++)
                if (board[row][col] + prefixSum[row][col] > 0) answer++;
        
        return answer;
    }
}

/* 효율성 실패 -> 알고리즘 있나봄 -> 공부 필요
공부1 : https://www.youtube.com/watch?v=7AJENb4CR78
및 검색

    public int solution(int[][] board, int[][] skill) {
        for (int[] info : skill) {
            int sRow = info[1], sCol = info[2],
                eRow = info[3], eCol = info[4],
                health = info[0] == 1 ? -1 * info[5] : info[5];
            addHealth(board, sRow, sCol, eRow, eCol, health);
        }
        
        int answer = 0;
        for (int[] row : board) {
            for (int col : row) {
                if (col > 0) answer++;
            }
        }
        
        return answer;
    }
    
    private void addHealth(int[][] board, int sRow, int sCol, int eRow, int eCol, int health) {
        for (int row = sRow; row <= eRow; row++) {
            for (int col = sCol; col <= eCol; col++) {
                board[row][col] += health;
            }
        }
    }
*/