import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[] {0, 0};
        
        // 움직일 수 있는 방향 지정
        int[][] dxys = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (picture[row][col] == 0) visited[row][col] = true;   // 0 == 빈공간 == 탐색할 필요 없음
                if (visited[row][col]) continue;                        // 이미 탐색한 경우

                // BFS --
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[] {row, col});
                visited[row][col] = true;
                
                int count = 0;
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    count++;
                    
                    // 움직일 수 있는 방향들 확인
                    for (int[] dxy : dxys) {
                        int newRow = poll[0] + dxy[0],
                            newCol = poll[1] + dxy[1];

                        // 장외
                        if (newRow < 0 || newRow >= m) continue;    
                        if (newCol < 0 || newCol >= n) continue;
                        // 이미 방문
                        if (visited[newRow][newCol]) continue;
                        // 같은 영역 아님
                        if (picture[row][col] != picture[newRow][newCol]) continue;
    
                        queue.offer(new int[] {newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
                // -- BFS
                answer[0]++;
                answer[1] = Math.max(answer[1], count);
            }
        }
        
        return answer;
    }
}

// 문제 요약
// 그림속에서 [영역 개수, 가장 큰 영역 내의 블럭 개수] return
// 방향 : 상 하 좌 우 (대각선 X)
// 0 : 빈공간

/* [Test Code] 2, 6
1   1   1   0
1   1   1   0
0   0   0   1
0   0   0   1
0   0   0   1
0   0   0   1
*/