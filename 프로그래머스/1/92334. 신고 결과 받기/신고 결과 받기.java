import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report_list, int k) {
        
        //id : id를 신고한 유저
        Map<String, Set<String>> reportLog = new HashMap<>();
        //결과 값 Map
        Map<String, Integer> resultMap = new HashMap<>();
        
        //Map 초기화
        for (String id : id_list) {
            reportLog.put(id, new HashSet<>());
            resultMap.put(id, 0);
        }
        
        for (String report : report_list) {
            //(신고한사람, 신고당한사람)
            String[] rUAT = report.split(" "); //reportUserAndTarget
   
            //신고당한사람 : 신고한사람추가
            reportLog.get(rUAT[1]).add(rUAT[0]);
        }
    
        //결과값 담을 배열
        int[] answer = new int[id_list.length];
        
        for (String id : id_list) {
            if (reportLog.get(id).size() < k) continue;
            //id 신고 당한 횟수가 k보다 크면
            for (String s : reportLog.get(id)) {
                //s는 신고한 사람
                resultMap.put(s, resultMap.get(s) + 1);
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = resultMap.get(id_list[i]);
        }
        
        return answer;
    }
}


/*
 - User 1:N 신고 , But 동일인물은 1회만 판정
 - k 번 이상 신고된 유저 = 게시판 정지, 신고한사람한테 정지처분 메일 발송
 - 각 유저별 처리 결과를 메일로 받는 횟수
 
 3, 11, 14, 15, 20 ,21 시간초과
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report_list, int k) {
        
        //Map<유저 : 제재성공메일>
        Map<String, Integer> resultMap = new HashMap<>();
        
        //Map 초기화
        for (String id : id_list) resultMap.put(id, 0);

        for (String id : id_list) {
            //id를 신고한 유저 목록 담을 Set
            Set<String> hashSet = new HashSet<>();
            
            for (String report : report_list) {
                //[0]은 신고한 [1]은 신고당한
                String[] reportLog = report.split(" ");

                //set에 id를 신고한 사람 넣기
                if (reportLog[1].equals(id)) hashSet.add(reportLog[0]);
            }
            
            //id가 제재 대상이면
            if (hashSet.size() >= k)
                //id를 신고한사람 메일 카운트 증가
                for (String rMU : hashSet) resultMap.put(rMU, resultMap.get(rMU) + 1);
        }
        
        //결과값
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) answer[i] = resultMap.get(id_list[i]);

        return answer;
    }
}
*/