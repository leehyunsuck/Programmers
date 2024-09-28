import java.util.*;

class Solution {
    public int solution(int[] aArr, int[] bArr) {
        Arrays.sort(aArr);
        Arrays.sort(bArr);
        
        int answer = 0;
        for (int i = 0; i < aArr.length; i++)
            answer += aArr[i] * bArr[bArr.length-i-1];

        return answer;
    }
}