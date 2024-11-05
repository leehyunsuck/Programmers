import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int maxLen = number.length() - k;
        
        for (char c : number.toCharArray()) {
            int num = c - '0';
            while (!stack.isEmpty() && num > stack.peek() && k-- > 0) 
                stack.pop();
            stack.push(num);
        }
        
        while (k-- > 0)
            stack.pop();
        
        StringBuilder answer = new StringBuilder();
        for (int num : stack)
            answer.append(num);
        
        return answer.toString();
    }
}