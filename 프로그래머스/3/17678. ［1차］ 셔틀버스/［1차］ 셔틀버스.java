import java.util.*;

class Solution {
    private static String BUS_FIRST_TIME = "09:00";
    /**
     * @param n         셔틀 운영 횟수
     * @param t         셔틀 운행 간격
     * @param m         한 셔틀에서 탈 수 있는 최대 사람 수
     * @param timetable 사람들이 대기열에 도착하는 시간 배열 (이거 정렬 안되어있음)
     *
     * @return 탑승 가능한 가장 마지막 시간
     */
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;
        
        PriorityQueue<Integer> peopleWaitTimes = new PriorityQueue<>();
        for (String time : timetable)
            peopleWaitTimes.offer(toInt(time));
        
        for (int busCount = 0, busTime = toInt(BUS_FIRST_TIME); busCount < n; busCount++, busTime += t) {
            int sitCount = 0;
            
            while (!peopleWaitTimes.isEmpty() && peopleWaitTimes.peek() <= busTime && sitCount < m) {
                sitCount++;
                answer = peopleWaitTimes.poll() - 1;
            }
            
            if (busCount == n - 1 && sitCount < m) 
                answer = busTime;
        }
        
        return toStr(answer);
    }
    
    // 정수 형태의 분을 "00:00" 형태의 문자열 시간으로 변환
    private String toStr(int time) {
        String hour = String.valueOf(time / 60),
               min  = String.valueOf(time % 60);
        
        if (hour.length() == 1) hour = "0" + hour;
        if (min.length()  == 1) min  = "0" + min;
        
        return hour + ":" + min;
    }
    
    // "00:00" 형태의 문자열 시간을 정수 형태의 분으로 변환
    private int toInt(String time) {
        String[] split = time.split(":");
        
        int hour = Integer.parseInt(split[0]),
            min  = Integer.parseInt(split[1]);
        
        return hour * 60 + min;
    }
}