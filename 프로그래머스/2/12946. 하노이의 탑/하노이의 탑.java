import java.util.*;

class Solution {
    List<int[]> answer;
    
    public int[][] solution(int n) {
        this.answer = new ArrayList<>();
        hanoi(n, 1, 2, 3);
        
        return this.answer.toArray(int[][]::new);
    }
    
    public void hanoi(int n, int from, int via, int  to) {
        if (n == 1) {
            this.answer.add(new int[] {from, to});
            return;
        }
        
        hanoi(n - 1, from, to, via);
        this.answer.add(new int[] {from, to});
        hanoi(n - 1, via, from, to);
    }
}