class Solution {
    /**
     * 희망 출근 시간과 출근한 시간이 주어질 때
     * 평일에 희망시간 ~ +10m 내에 출근을 처음부터 끝까지 제대로 한 직원 찾기
     *
     * @Param schedules[]   idx번째 사람이 설정한 희망시간
     * @Param timelogs[][]  [idx]번째 사람이 출근한 시간
     * @Param startday      1 ~ 7 , 월 ~ 일
     * 
     * @Return 제한시간을 지킨 인원 수
     */
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int result = 0;
        
        for (int user = 0; user < schedules.length; user++) {
            int safeTime = timeToMin(schedules[user]) + 10,
                day = startday - 1;
            
            boolean getGift = true;
            for (int timeLog : timelogs[user]) {
                if (++day == 8) day = 1;
                
                if (day <= 5) {
                    if (timeToMin(timeLog) <= safeTime) continue;
                    getGift = false;
                    break;
                }
            }
            
            if (getGift) result++;
        }
        
        return result;
    }
    
    private int timeToMin(int time) {
        int hour = time / 100,
            min  = time % 100;
        
        return hour * 60 + min;
    }
}