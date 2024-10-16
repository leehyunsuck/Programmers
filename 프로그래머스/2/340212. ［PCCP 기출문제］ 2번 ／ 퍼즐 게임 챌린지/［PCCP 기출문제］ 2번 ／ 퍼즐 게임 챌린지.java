class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int minLevel = 1,
            maxLevel = 0;
        for (int diff : diffs)
            if (diff > maxLevel) maxLevel = diff;

        while (minLevel <= maxLevel) {
            int midLevel = (minLevel + maxLevel) / 2;
            long time = this.useTime(diffs, times, midLevel);
            
            //System.out.println(midLevel + ", " + time);
            
            if (time > limit) 
                minLevel = midLevel + 1;
            else
                maxLevel = midLevel - 1;
        }
        
        return minLevel;
    }
    
    public long useTime(int[] diffs, int[] times, int level) {
        long useTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (level >= diffs[i]) useTime += times[i];
            else useTime += (times[i] + (i > 0 ? times[i-1] : 0)) * (diffs[i] - level) + times[i];
        }
        return useTime;
    }
}

/*
diff        : 난이도
time_cur    : 현재 퍼즐 소요 시간
time_prev   : 이전 퍼즐 소요 시간
level       : 숙련도

diff <= level
    - time_cur 만큼 사용하여 해결
    
else
    - diff - level 번 틀림
    - 틀릴 때 마다 이전 퍼즐을 다시 풀고 와야함 (즉 그 시간만큼 더 소모)
    
limit 제한 시간 내 해결 가능한, 최소 해결 숙련도값

*/