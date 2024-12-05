import java.util.*;

class Solution {
    List<int[]> answer;
    
    private void reset() {
        answer = new ArrayList<>();
    }
    
    public int[][] getAnswer() {
        return answer.toArray(int[][]::new);
    }
    
    public void hanoi(int n, int from, int via, int to) {
        if (n == 1) {
            answer.add(new int[] {from, to});
        } else {
            hanoi(n - 1, from, to, via);
            answer.add(new int[] {from, to});
            hanoi(n - 1, via, from, to);
        }    
    }

    public int[][] solution(int n) {
        reset();
        hanoi(n, 1, 2, 3);
        return getAnswer();
    }

}