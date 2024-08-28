import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i : ingredient) {
            stack.push(i);
            int len = stack.size();
            
            if (len < 4) continue;
            
            if (stack.get(len - 4) == 1 && stack.get(len - 3) == 2 &&
                stack.get(len - 2) == 3 && stack.get(len - 1) == 1) {
                answer++;
                for (int repeat = 0; repeat < 4; repeat++) stack.pop();
            }
        }
        
        return answer;
    }
}