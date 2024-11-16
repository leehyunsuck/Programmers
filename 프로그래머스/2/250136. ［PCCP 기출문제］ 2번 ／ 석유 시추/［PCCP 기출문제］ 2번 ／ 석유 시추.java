import java.util.*;

class Solution {
    private static int[] dR = {0, 0, -1, 1};
    private static int[] dC = {1, -1, 0, 0};
    
    public int solution(int[][] land) {
        int[] howMany = new int[land[0].length];
        
        boolean[][] used = new boolean[land.length][land[0].length];
        
        Queue<int[]> queue = new LinkedList<>();
        
        for (int column = 0; column < land[0].length; column++) {
            for (int row = 0; row < land.length; row++) {
                // System.out.println("[시작] : " + row + ", " + column);
                if (used[row][column]) continue;        // 이미 방문 continue
                used[row][column] = true;               // 현재 위치 방문으로 처리 (벽이여도 방문은 한거니까)
                if (land[row][column] == 0) continue;   // 벽이면 continue
                
                Set<Integer> cIdx = new HashSet<>();    // 각 줄 마다 얼마나 시추 가능한지 계산용
                cIdx.add(column);
                
                int count = 1;                          // 석유 용량
                queue.offer(new int[] {row, column});   // BFS 시작
                // System.out.println("    탐색 시작");
                
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int r = poll[0],    
                        c = poll[1];
                    
                    for (int dIdx = 0; dIdx < dR.length; dIdx++) {
                        int nextR = r + dR[dIdx],
                            nextC = c + dC[dIdx];
                        
                        // 장외 확인
                        if (nextR < 0 || nextR >= land.length) continue;
                        if (nextC < 0 || nextC >= land[nextR].length) continue;
                        // 이미 방문 확인
                        if (used[nextR][nextC]) continue;
                        
                        // 방문 처리
                        used[nextR][nextC] = true;
                        // 벽인지 확인
                        if (land[nextR][nextC] == 0) continue;
                        
                        // [경] 석유칸이고, 벽도, 장외도, 이미 방문도 아님 [축]
                        count++;
                        queue.offer(new int[] {nextR, nextC});
                        cIdx.add(nextC);
                    } /* nextLocation (for) */
                } /* BFS (while) */
                // System.out.println("    시추 가능 : " + count);
                // 석유 양 더하기
                for (int idx : cIdx)
                    howMany[idx] += count;
            } /* row (for) */
        } /* column (for) */
        
        // System.out.println("-------------");
        int answer = 0;
        for (int count : howMany) {
            answer = Math.max(answer, count);
            // System.out.println("시추 가능 수 : " + count);
        }
        
        return answer;
    }
}