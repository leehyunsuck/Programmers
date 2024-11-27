import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        // 시작위치, 레버위치 저장용
        int[] start  = new int[2],
              button = new int[2];
        
        // 찾으면 반복 안하려는 용도
        boolean findS = false, 
                findB = false;
        
        // 찾을겸 사용하기 편할겸 String[] -> char[][]
        char[][] map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
            
            if (findS && findB) continue;
            // 시작위치, 레버위치 찾기
            for (int j = 0; j < map[i].length; j++) {
                if (!findS && map[i][j] == 'S') {
                    start = new int[] {i, j};
                    findS = true;
                } else if (!findB && map[i][j] == 'L') {
                    button = new int[] {i, j};
                    findB = true;
                }
            }
        }
        
        // 이미 탐색여부 저장
        boolean[][] used = new boolean[map.length][map[0].length];
        
        // BFS 탐색 Queue
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        
        // 레버 찾기 탐색 결과 받기
        int moveCountFindBtn = bfs(map, used, queue, 'L');
        if (moveCountFindBtn == 0) return -1;   // 못나감
        answer += moveCountFindBtn;
        
        // 다시 출구까지 빠른 경로 찾아야하므로 초기화 및 레버위치부터 시작
        queue.clear();
        queue.offer(button);
        used = new boolean[map.length][map[0].length];
        
        // 출구 찾기 탐색 결과 받기
        int moveCountFindExit = bfs(map, used, queue, 'E');
        if (moveCountFindExit == 0) return -1;  // 못나감
        answer += moveCountFindExit;
        
        return answer;
    }
    
    // 레버찾기, 문찾기 총 2번 사용해야해서 따로 뺌
    public int bfs(char[][] map, boolean[][] used, Queue<int[]> queue, char target) {
        int moveCount = 0;
        queue.offer(null);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            
            if (poll == null) {
                moveCount++;
                if (!queue.isEmpty())
                    queue.offer(null);
                continue;
            }
            
            int row = poll[0],
                col = poll[1];
            
            // 장외, 이미 방문, 벽이면 탐색안함
            if (row < 0 || row >= map.length
                || col < 0 || col >= map[row].length
                || used[row][col] || map[row][col] == 'X') {
                continue;
            }

            used[row][col] = true;
            
            if (map[row][col] == target) {
                return moveCount;
            }
            
            queue.offer(new int[] {row + 1, col});
            queue.offer(new int[] {row - 1, col});
            queue.offer(new int[] {row, col + 1});
            queue.offer(new int[] {row, col - 1});
        }
        return 0;
    }
}