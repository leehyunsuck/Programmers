class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int maxHeight = board.length - 1;
        int maxWeight = board[0].length - 1;
        int[] numbers = {h+1, h-1, w+1, w-1};
        
        String color = board[h][w];
        
        for(int i = 0; i < 4; i++) {
            if (numbers[i] < 0) continue;
            if (i <= 1 && numbers[i] <= maxHeight) answer += board[numbers[i]][w].equals(color) ? 1 : 0;
            else if (i >= 2 && numbers[i] <= maxHeight) answer += board[h][numbers[i]].equals(color) ? 1 : 0;
        }

        return answer;
    }
}