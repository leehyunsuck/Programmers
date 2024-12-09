import java.util.*;

class Solution {
    // String[][] 보드들을 List<char[][]> 로 변환
    private List<char[][]> changeBoardType(String[][] places) {
        List<char[][]> result = new ArrayList<>();
        
        for (String[] place : places) {
            char[][] arr = new char[5][5];
            
            int idx = 0;
            for (String p : place) {
                arr[idx++] = p.toCharArray();
            }
            result.add(arr);
        }
        
        return result;
    }

    // 보드 전체 출력 (테스트용)
    private void printBoards(List<char[][]> boards) {
        for (char[][] board : boards) {
            printBoard(board);
            System.out.println();
        }
    }
    
    // 보드 하나 출력 (테스트용)
    private void printBoard(char[][] board) {
        for (char[] b : board)
            System.out.println(Arrays.toString(b));
    }
    
    // 보드 전체 규칙 지킴 여부 확인하고 결과 배열에 반영
    private void checkBoardsAndSet(int[] result, List<char[][]> boards) {
        int idx = 0;
        for (char[][] board : boards) {
            result[idx++] = isPass(board);
        }
    }
    
    // 보드가 규칙을 지킨건지 확인
    private int isPass(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] != 'P') continue;
                if (checkNearPeople(board, row, col, 2)) return 0;
            }
        }
        
        return 1;
    }
    
    // maxLen칸 이내에 사람 있는지 BFS 탐색
    private boolean checkNearPeople(char[][] board, int row, int col, int maxLen) {
        int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 상 하 좌 우
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col, 0});       // {row, col, moveCount}
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        visited[row][col] = true;
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            int r = poll[0],
                c = poll[1],
                m = poll[2];
            
            if (m >= maxLen) continue;  // 최대 이동 횟수 초과
            
            for (int[] move : moves) {
                int nR = r + move[0],
                    nC = c + move[1];
                
                if (nR < 0 || nR >= board.length) continue;     // 장외
                if (nC < 0 || nC >= board[nR].length) continue; // 장외
                if (visited[nR][nC]) continue;                  // 이미 탐색한 곳
            
                visited[nR][nC] = true;
                
                if (board[nR][nC] == 'P') return true;
                
                if (board[nR][nC] == 'O')   // 벽(X)이 아닌 빈 공간(O)일때만 이동 가능
                    queue.offer(new int[] {nR, nC, m + 1});
            }
        }
        
        return false;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        List<char[][]> boards = changeBoardType(places);
        checkBoardsAndSet(answer, boards);

        return answer;
    }

}
