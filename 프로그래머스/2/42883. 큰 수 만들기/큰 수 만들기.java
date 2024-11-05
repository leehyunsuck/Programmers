import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int len = number.length(),
            maxIdx = 0;
        
        for (int idx = 0; idx < len - k; idx++) {   // 0번 인덱스부터 쭉 이어보기
            char maxChar = '0';
            
            for (int sIdx = maxIdx; sIdx <= k + idx; sIdx++) {
                if (number.charAt(sIdx) > maxChar) {
                    maxChar = number.charAt(sIdx);
                    maxIdx = sIdx + 1;      // 가장 큰 값 다음부터 체크해야함
                }
            }
            answer.append(maxChar);
        }
        
        return answer.toString();
    }
}