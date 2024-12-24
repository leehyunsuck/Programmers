class Solution {    
    public int solution(int n, int[] stations, int w) {
        int answer = 0,
            basicStationIdx = 0,
            nowStation = 1,
            cover = 2 * w + 1;
        
        while (nowStation <= n) {
            int basicStationMin = Integer.MAX_VALUE;
            if (basicStationIdx < stations.length)
                basicStationMin = stations[basicStationIdx] - w;
            
            if (nowStation >= basicStationMin) {
                nowStation = stations[basicStationIdx] + w + 1;
                basicStationIdx++;
                continue;
            }
            
            answer++;
            nowStation += cover;
        }
        
        return answer;
    }
}

/*
class Solution {    
    public int solution(int n, int[] stations, int w) {
        int addCount = 0;
        
        boolean[] canCommunication = new boolean[n];
        for (int station : stations) {
            setCanCommunication(canCommunication, station, w);
        }
 
        for (int idx = 0; idx < canCommunication.length; idx++) {
            if (canCommunication[idx]) continue;
            setCanCommunication(canCommunication, idx + w + 1, w);
            addCount++;
        }
        
        return addCount;
    }
    
    public void setCanCommunication(boolean[] boolArrs, int station, int w) {
        int startIdx = station - w - 1,
            endIdx   = station + w;
            
        if (startIdx < 0) startIdx = 0;
        if (endIdx > boolArrs.length) endIdx = boolArrs.length;
            
        for (int idx = startIdx; idx < endIdx; idx++) {
            if (!boolArrs[idx]) 
                boolArrs[idx] = true;
        }
    }
}
*/