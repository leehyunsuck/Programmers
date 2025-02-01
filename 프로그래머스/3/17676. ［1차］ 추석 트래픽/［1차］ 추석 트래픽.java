import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int[][] logs = new int[lines.length][2];
        
        for (int idx = 0; idx < logs.length; idx++) {
            String[] log = lines[idx].split(" ");
            logs[idx][1] = toMiliSecond(log[1]);
            logs[idx][0] = logs[idx][1] - toMiliSecond(log[2].replace("s", "")) + 1;
        }
        
        return getMaxProcessOneSecond(logs);
    }
    
    // 1초동안 가장 많이 처리한 작업 개수
    private int getMaxProcessOneSecond(int[][] logs) {
        int result = 0;
        for (int i = 0, count = 0; i < logs.length; i++, count = 0) {
            for (int j = i, oneSecStart = logs[i][1], oneSecEnd   = oneSecStart + 999; j < logs.length; j++) {
                if (logs[j][0] > oneSecEnd ||
                    logs[j][1] < oneSecStart) continue;
                count++;
            }
            if (result < count) result = count;
        }
        
        return result;
    }
    
    // "HH:MM:SS.SSS", "S.SSS" 형태의 문자열을 밀리초 단위의 정수로 반환
    private int toMiliSecond(String time) {
        if (time.length() <= 5) {
            if (time.length() == 1) return Integer.parseInt(time) * 1_000;
            
            String[] split = time.split("\\.");
            while (split[1].charAt(0) == 0)
                split[1] = split[1].substring(1) + "0";
            
            return Integer.parseInt(split[0]) * 1_000 + Integer.parseInt(split[1]);
        }
        int hour = Integer.parseInt(time.substring(0, 2)), min     = Integer.parseInt(time.substring(3, 5)),
            sec  = Integer.parseInt(time.substring(6, 8)), miliSec = Integer.parseInt(time.substring(9));
        
        return (hour * 3600 + min * 60 + sec) * 1000 + miliSec;
    }
}