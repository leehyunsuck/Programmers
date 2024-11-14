import java.util.*;

class Solution {
    public int[] solution(String[] ids, String[] reports, int k) {
        Map<String, Integer> answerMap = new HashMap<>();       // 유저 : 메일 받을 개수
        Map<String, Set<String>> reportMap = new HashMap<>();   // 신고대상 : 신고자 (중복x)

        // 두 맵 초기화
        for (String id : ids) {
            answerMap.put(id, 0);
            reportMap.put(id, new HashSet<>());
        }

        // reportMap 데이터 저장
        for (String report : reports) {
            // [0] -> 신고자, [1] -> 신고 대상
            String[] reportSplit = report.split(" ");

            Set<String> reportSet = reportMap.get(reportSplit[1]);
            reportSet.add(reportSplit[0]);
            reportMap.put(reportSplit[1], reportSet);
        }

        // 메일 받을 사람 확인
        for (String id : ids) {
            Set<String> reportSet = reportMap.get(id);

            if (reportSet.size() < k) continue;
            for (String report : reportSet)
                answerMap.put(report, answerMap.get(report) + 1);
        }

        int[] answer = new int[answerMap.size()];
        for (int i = 0; i < answer.length; i++)
            answer[i] = answerMap.get(ids[i]);

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