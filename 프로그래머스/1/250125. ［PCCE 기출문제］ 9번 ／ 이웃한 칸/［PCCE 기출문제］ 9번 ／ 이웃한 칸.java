class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int maxLength = board.length - 1;
        int[] moves = {h+1, h-1, w+1, w-1};
        
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++) {
            if (moves[i] < 0 || moves[i] > maxLength) continue;
            
            if (i <= 1 && board[moves[i]][w].equals(color)) ++answer;
            else if (i >= 2 && board[h][moves[i]].equals(color)) ++answer;
        }

        return answer;
    }
}