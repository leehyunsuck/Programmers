import java.util.*;
import java.util.function.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Function<String, Integer> getIndex = str -> switch (str) {
                case "code" -> 0;
                case "date" -> 1;
                case "maximum" -> 2;
                case "remain" -> 3; 
                default -> 0;
        };
        
        int extIdx = getIndex.apply(ext);
        int sortIdx = getIndex.apply(sort_by);
        
        List<int[]> answerList = new ArrayList<>();
        
        for (int[] dataInfo : data) {
            //[0] ~ [3] = code, date, maximum, remain
            if (dataInfo[extIdx] >= val_ext) continue;
            answerList.add(dataInfo);
        }
        
        answerList.sort(Comparator.comparingInt(tList -> tList[sortIdx]));
        
        int[][] answer = new int[answerList.size()][4];
        for (int i = 0; i < answerList.size(); i++) answer[i] = answerList.get(i);
        
        return answer;
    }
}

// ext 가 표시하고 있는 종류의 값이
// val_ext 보다 작은
// sort_by 값을 기준으로 오름 차순 정렬