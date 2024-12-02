import java.util.*;

class Solution {
    public int[] solution(String[] ids, String[] reports, int k) {
        // ids : 모든 유저의 이름
        // reports : [누가 누구를] 신고여부
        // k : 신고 몇번 당해야 정지냐
        
        /* ------------------------------------------------------------- */
        
        // 규칙1. 신고 제한 없음
        // 규칙2. 동일한 유저에 대한 신고는 1회만 처리 됨
        
        /* ------------------------------------------------------------- */
        
        // 로직1. reports를 조회해서 특정유저를 누가 신고했는지 저장
        //          -> 단 규칙2 지키면서
        // 필요 자료구조  : Map -> String으로 조회해야함
        //              : Set -> (규칙2) 동일한 신고자는 1회만 처리

        
        // 로직2. 유저마다 정지 여부 판단
        //          -> 정지다? 해당 유저를 신고한 사람들은 받을 메일 개수 증가
        // 필요 자료구조  : Map -> 유저별로 몇개의 메일 받는지
        
        /* ------------------------------------------------------------- */
        
        // 필요한 자료구조 선언
        // Key : 유저이름 , Value : 신고 한 사람 목록
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> getMailCountMap = new HashMap<>();
        
        // 선언한 자료구조 초기화
        for (String id : ids) {
            reportMap.put(id, new HashSet<>());
            getMailCountMap.put(id, 0);
        }
        
        // [로직1] 수행
        for (String report : reports) {
            String[] reportInfo = report.split(" ");    //[누가 누구] 이렇게 들어가있으니 공백으로 나눔
            String sendUser   = reportInfo[0],          // 누가 신고했는지
                   targetUser = reportInfo[1];          // 누구를 신고했는지
            
            reportMap.get(targetUser).add(sendUser);    // 저장
        }
        
        // [로직2] 수행
        for (String userName : reportMap.keySet()) {
            Set<String> usersWhoReported = reportMap.get(userName);
            if (usersWhoReported.size() < k) continue;  // k 보다 작으면 정지 안당함

            // 정지임 -> 해당 유저를 신고한 사람들에게 메일 전송해야함
            for (String user : usersWhoReported) {
                getMailCountMap.put(user, getMailCountMap.get(user) + 1);
            }
        }
        
        int[] answer = new int[ids.length];
        int idx = 0;
        for (String id : ids) {
            answer[idx++] = getMailCountMap.get(id);
        }

        // k번 이상 신고된 유저가 정지되었을 되었을 때 받을 메일의 개수
        return answer;
    }
}