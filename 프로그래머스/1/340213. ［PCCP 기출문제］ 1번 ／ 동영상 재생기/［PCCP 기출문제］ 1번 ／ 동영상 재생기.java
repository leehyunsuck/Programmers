class Solution {
    
    public int convertToSeconds(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 각 시간들 초로 변환
        int videoLenSec = convertToSeconds(video_len),
            posSec = convertToSeconds(pos),
            opStartSec = convertToSeconds(op_start),
            opEndSec = convertToSeconds(op_end);
 
        if (posSec >= opStartSec && posSec <= opEndSec) posSec = opEndSec; // 시작 값 오프닝 구간 확인
        
        for (String command : commands) {
            if (command.equals("next")) posSec = posSec + 10 >= videoLenSec ? videoLenSec : posSec + 10;
            else posSec = posSec - 10 > 0 ? posSec - 10 : 0;
            
            if (posSec >= opStartSec && posSec <= opEndSec) posSec = opEndSec; // 오프닝 구간 확인
        }
        
        int m = posSec / 60,
            s = posSec % 60;
        
        String answer = "";     // StringBuilder 쓸정도 아님
        answer += m < 10 ? "0" + m : m + "";
        answer += ":";
        answer += s < 10 ? "0" + s : s + "";
        
        return answer;
    }
}