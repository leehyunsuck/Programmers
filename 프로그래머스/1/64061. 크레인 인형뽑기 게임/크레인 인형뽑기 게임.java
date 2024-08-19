import java.util.*;

class Solution {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Map<Integer, Queue<Integer>> dollMap = new HashMap<>();
        for (int[] b : board) {
            for (int i = 0; i < b.length; i++) {
                if (b[i] == 0) continue;
                
                Queue<Integer> putQueue;
                if (dollMap.containsKey(i)) putQueue = dollMap.get(i);
                else putQueue = new LinkedList<>();
   
                putQueue.add(b[i]);
                dollMap.put(i, putQueue);
            }
        }
        
        int[] tempSave = new int[moves.length];
        int idx = 0;
        for (int m : moves) {
            if (dollMap.get(m-1).isEmpty()) continue;
            
            tempSave[idx++] = dollMap.get(m-1).poll();
        
            while(idx > 1 && tempSave[idx-1] == tempSave[idx-2]) {
                idx -= 2;
                answer += 2;
            }
        }

        return answer;
    }
}