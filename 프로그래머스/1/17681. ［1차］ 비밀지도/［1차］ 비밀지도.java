import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            String strNum = Integer.toString(arr1[i] | arr2[i], 2);
            while (strNum.length() < n)
                strNum = "0" + strNum;

            StringBuilder appendValue = new StringBuilder();
            for (int j = 0; j < strNum.length(); j++)
                appendValue.append(strNum.charAt(j) == '1' ? "#" : " ");
                
            answer[i] = appendValue.toString();
        }

        return answer;
    }
}