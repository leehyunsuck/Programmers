import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        // 정렬한 값 return하라니까 처음부터 pQ씀
        Queue<Integer> answerQ = new PriorityQueue<>();
        
        // 접근하기 편하게 이중배열 하나 제작 
        char[][] map = new char[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++)
            map[i] = maps[i].toCharArray();
    
        // 이미 칸 탐색 했는지 확인용
        boolean[][] used = new boolean[map.length][map[0].length];
        
        // 무인도 전체 조회
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[0].length; column++) {
                if (used[row][column]) continue;    // 이미 탐색함
                
                if (map[row][column] == 'X') {      // 바다임
                    used[row][column] = true;
                    continue;
                }

                // 탐색도 안했고, 바다도 아님 -> 주변 탐색 시작 (DFS로 구현)
                int sum = 0;
                
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[] {row, column});
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int r = poll[0],
                        c = poll[1];
                    
                    if (r < 0 || r >= map.length) continue;     // 맵 밖임
                    if (c < 0 || c >= map[0].length) continue;  // 맵 밖임
                    if (used[r][c]) continue;                   // 이미 탐색함
                    if (map[r][c] == 'X') continue;             // 바다임
                    
                    sum += map[r][c] - '0';
                    used[r][c] = true;
                    
                    queue.offer(new int[] {r + 1, c});
                    queue.offer(new int[] {r - 1, c});
                    queue.offer(new int[] {r, c + 1});
                    queue.offer(new int[] {r, c - 1});
                }
                answerQ.offer(sum);
            }
        }
        if (answerQ.size() == 0) return new int[] {-1};         // 시드 개망 다 바다임
        
        int[] answer = new int[answerQ.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerQ.poll();
        
        return answer;
    }
}