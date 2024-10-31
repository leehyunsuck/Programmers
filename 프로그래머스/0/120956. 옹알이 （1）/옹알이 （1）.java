import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0,
            maxLen = 0;
        
        // 할 수 있는 발음인지 확인하는 용도
        String[] possibleWords = { "aya", "ye", "woo", "ma" };
        
        Set<String> set = new HashSet<>();
        for (String possibleWord : possibleWords) {
            set.add(possibleWord);
            if (possibleWord.length() > maxLen) maxLen = possibleWord.length();
        }
        
        // 배열에 있는 모든 단어 탐색
        for (String word : babbling) {
            // LIFO 구조에 넣어서 뒤에서부터 확인
            Stack<Character> stack = new Stack<>();            
            for (char w : word.toCharArray())
                stack.add(w);
            
            boolean pass = false;
            while (!stack.isEmpty()) {
                pass = false;
                
                char[] temp = new char[maxLen];
                for (int i = maxLen - 1; i >= 0; i--) {
                    temp[i] = stack.pop();
                    // 있는 값이면 최소 글자수 단어인 경우도 있으니 멈추기
                    if (set.contains(String.valueOf(temp).trim())) {
                        pass = true;
                        break;
                    }
                    if (stack.isEmpty()) break;
                }
                if (!pass) break;   // 최대 글자 수 까지 없던 단어이므로 멈추기
            }
            // 전부 비울 때 까지 true면 모두 발음 가능한거임
            if (pass) answer++;
        }
        
        return answer;
    }
}