import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        
        int[]   countX = new int[10],
                countY = new int[10],
                answerCount = new int[10];
        
        for (char c : X.toCharArray()) countX[c - '0']++;
        for (char c : Y.toCharArray()) countY[c - '0']++;
        for (int i = 0; i < 10; i++) answerCount[i] = Math.min(countX[i], countY[i]);
        
        StringBuilder answer = new StringBuilder();
        for (int i = 9; i >= 0; i--) 
            for (int j = 0; j < answerCount[i]; j++) answer.append(i);
        
        if (answer.length() == 0) return "-1";
        if (answer.charAt(0) == '0') return "0";
        return answer.toString();
    }
}

/*
방식 변경 -> 공통 숫자 개수 파악하면 되잖아..? 왜 찾기 생각만 했지


실패 코드

        
        byte[]  xArray = new byte[X.length()],
                yArray = new byte[Y.length()];

        for (int i = 0; i < X.length(); i++) xArray[i] = (byte) (X.charAt(i) - '0');
        for (int i = 0; i < Y.length(); i++) yArray[i] = (byte) (Y.charAt(i) - '0');
        Arrays.sort(xArray);
        Arrays.sort(yArray);
   
        byte[] longer = (xArray.length > yArray.length) ? xArray : yArray;
        byte[] shorter = (xArray.length > yArray.length) ? yArray : xArray;

        List<Byte> answerList = new ArrayList<>();
        Map<Byte, Integer> fIdxMap = new HashMap<>();
        for (int i = 0; i < longer.length; i++) {
            int fromIdx = fIdxMap.getOrDefault(longer[i], 0);
            int findIdx = Arrays.binarySearch(shorter, fromIdx, shorter.length, longer[i]);
            if (findIdx < 0) continue;
            answerList.add(longer[i]);
            fIdxMap.put(longer[i], fromIdx + 1);
        }
        answerList.sort(Comparator.reverseOrder());
        
        if (answerList.size() == 0) return "-1";
        if (answerList.get(0) == 0) return "0";
        
        StringBuilder answer = new StringBuilder();
        for (int i : answerList) answer.append(String.valueOf(i));
        
        return answer.toString();

*/