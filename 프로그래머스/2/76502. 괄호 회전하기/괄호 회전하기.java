import java.util.*;

class Solution {
    public boolean check(Queue queue) {
        int[] size = new int[] {0, 0, 0};
        
        while (!queue.isEmpty()) {
            char c = (char) queue.remove();
            
            switch (c) {
                    case '(' -> size[0] = size[0] + size[1] + size[2] + 1;
                    case ')' -> size[0] = size[0] - size[1] - size[2] - 1;
                    case '{' -> size[1] = size[1] + size[2] + 1;
                    case '}' -> size[1] = size[1] - size[2] - 1;
                    case '[' -> size[2]++;
                    case ']' -> size[2]--;
            }
            // 연 괄호가 없는데 닫힌 괄호가 있으면 false
            if (size[0] < 0 || size[1] < 0 || size[2] < 0) return false;
        }
        // 연 괄호가 남아있거나, 더 작은 괄호가 갇힌 경우
        return size[0] + size[1] + size[2] == 0;
    }
    
    public int solution(String s) {
        int answer = 0;

        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) 
            queue.add(c);
        
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            // 회전
            queue.add(queue.remove()); 
            
            // 옳바른 괄호 문자열 확인
            if (this.check(new LinkedList<>(queue))) answer++;
        }
        
        return answer;
    }
}