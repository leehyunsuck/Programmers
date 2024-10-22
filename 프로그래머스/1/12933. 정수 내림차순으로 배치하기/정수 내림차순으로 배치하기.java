class Solution {
    public long solution(long n) {
        String nToString = String.valueOf(n);
        
        char[] nToCharArr = nToString.toCharArray();
        
        for (int i = 0; i < nToCharArr.length; i++) {
            int bigIdx = i;
            
            for (int j = i + 1; j < nToCharArr.length; j++) {
                if (nToCharArr[j] > nToCharArr[bigIdx])
                    bigIdx = j;
            }
            
            if (bigIdx == i) continue;
            char tempSave = nToCharArr[i];
            nToCharArr[i] = nToCharArr[bigIdx];
            nToCharArr[bigIdx] = tempSave;
        }
        
        long answer = 0;
        for (char c : nToCharArr) {
            answer = answer * 10 + c - '0';
        }
        
        return answer;
    }
}