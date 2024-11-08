import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> secContainer = new Stack<>();
        
        int idx = 0;
        for (int box = 1; box <= order.length; box++) {
            secContainer.push(box);
            
            while(!secContainer.isEmpty() && secContainer.peek() == order[idx]) {
                answer++;
                idx++;
                secContainer.pop();
            }
        }

        return answer;
    }
}