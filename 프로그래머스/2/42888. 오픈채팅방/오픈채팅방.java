import java.util.*;

class Solution {
    private String[] basicMsg = {
        "님이 들어왔습니다.",
        "님이 나갔습니다."
    };
    
    public String[] solution(String[] record) {
        Map<String, String> kUidVnick = new HashMap<>();    // uuid : 마지막 사용 닉네임
        
        int changeCount = 0;                                // 저장이유 : 반환값에 닉네임 변경 기록은 안들어감
        for (String r : record) {
            String[] split = r.split(" ");
            if (split.length == 2) continue;
            if (split[0].equals("Change")) changeCount++;
            kUidVnick.put(split[1], split[2]);
        }
        
        String[] answer = new String[record.length - changeCount];
        
        for (int rIdx = 0, aIdx = 0; rIdx < record.length; rIdx++) {
            String[] split = record[rIdx].split(" ");
            if (split[0].equals("Change")) continue;
            int mIdx = split[0].equals("Enter") ? 0 : 1;      
            answer[aIdx++] = kUidVnick.get(split[1]) + basicMsg[mIdx];
        }
        
        return answer;
    }
}