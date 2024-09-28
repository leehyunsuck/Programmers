import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (s.length() != 1) {
            StringBuilder temp = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '0') answer[1]++;
                else temp.append("1");
            }
            answer[0]++;
            s = Integer.toString(temp.length(), 2);
        }
        
        return answer;
    }
}

// [이진 변환 횟수, 제거된 0의 모든 개수]

// 길이를 2진수로 반복