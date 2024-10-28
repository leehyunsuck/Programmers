import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Integer> stack = new Stack<>();
        for (int idx = 0; idx < numbers.length; idx++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[idx])
                answer[stack.pop()] = numbers[idx];
            stack.push(idx);
        }

        while (!stack.isEmpty())
            answer[stack.pop()] = -1;

        return answer;
    }
}
