import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int len = lines.length;
        int[][] times = new int[len][2];

        for (int i = 0; i < len; i++) {
            String[] log = lines[i].split(" ");
            int endTime   = toMiliSec(log[1]),
                needTime  = toMiliSec(log[2].replace("s", "")),
                startTime = endTime - needTime + 1;
            times[i][0] = startTime;
            times[i][1] = endTime;
        }

        int answer = 0;
        for (int i = 0; i < len; i++) {
            int endTime  = times[i][1],
                lastTime = endTime + 999;   // endTime부터 1초 판단이니까 999 더한 시간까지만
            
            int count = 0;
            for (int j = 0; j < len; j++) {
                if (times[j][1] < endTime) continue;
                if (times[j][0] > lastTime) continue;
                count++;
            }
            
            answer = Math.max(answer, count);
        }

        return answer;
    }

    private int toMiliSec(String time) {
        if (time.length() < 12) {
            if (time.length() == 1) return Integer.parseInt(time) * 1000;
            String[] split = time.split("\\.");
            return Integer.parseInt(split[0]) * 1000 + (split.length > 1 ? Integer.parseInt(split[1]) : 0);
        }
        int hour = Integer.parseInt(time.substring(0, 2));
        int min  = Integer.parseInt(time.substring(3, 5));
        int sec  = Integer.parseInt(time.substring(6, 8));
        int mils = (time.length() > 9) ? Integer.parseInt(time.substring(9)) : 0;

        min += hour * 60;
        sec += min * 60;
        mils += sec * 1000;

        return mils;
    }
}

// 너무 어려웠다