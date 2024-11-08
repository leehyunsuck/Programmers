import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> secContainer = new Stack<>();
        
        int idx = 0;
        for (int box = 1; box <= order.length; box++) {
            while (!secContainer.isEmpty() && secContainer.peek() == order[idx]) {
                answer++;
                idx++;
                secContainer.pop();
            }
            if (box == order[idx]) {
                answer++;
                idx++;
            } else {
                secContainer.push(box);
            }
        }

        while (!secContainer.isEmpty() && secContainer.peek() == order[idx]) {
                answer++;
                secContainer.pop();
                idx++;
        }

        return answer;
    }
}