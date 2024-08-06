import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        
        // name : { 준_개수, 받은_개수, 다음_달_받을_개수 }
        Map<String, Integer[]> totalInfo = new HashMap<>();
        
        // name : 나에게 준 사람
        Map<String, List<String>> getInfo = new HashMap<>();
        
        for (String name : friends) {
            totalInfo.put(name, new Integer[] {0, 0, 0});
            getInfo.put(name, new ArrayList<>());
        }
        
        // 데이터 저장
        for (String giftInfo : gifts) {
            // [0] 준 사람,  [1] 받은 사람
            String[] sendGetName = giftInfo.split(" ");
            
            totalInfo.get(sendGetName[0])[0] += 1;
            totalInfo.get(sendGetName[1])[1] += 1;
            
            getInfo.get(sendGetName[1]).add(sendGetName[0]);
        }
        
        // 계산 시작
        int answer = 0;
        
        for (int i = 0; i < friends.length - 1; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                String sender = friends[i];
                String receiver = friends[j];

                String name = null;
                
                // sender에게 receiver에게 받은 개수
                int senderGet = (int) getInfo.get(sender).stream().filter(n -> n.equals(receiver)).count();
                
                // sender가 receiver에게 준 개수
                int senderSend = (int) getInfo.get(receiver).stream().filter(n -> n.equals(sender)).count();
        
                //선물 더 많이 준 사람이 받기
                if (senderGet < senderSend) name = sender;
                else if (senderGet > senderSend) name = receiver;
                else { 
                    Integer[] senderInfo = totalInfo.get(sender);
                    Integer[] receiverInfo = totalInfo.get(receiver);
                    
                    // 선물 지수 계산
                    int senderGiftScore = senderInfo[0] - senderInfo[1];
                    int receiverGiftScore = receiverInfo[0] - receiverInfo[1];

                    //선물지수 큰 사람이 받기
                    if (senderGiftScore > receiverGiftScore) name = sender;
                    else if (senderGiftScore < receiverGiftScore) name = receiver;
                    else continue;
                }

                totalInfo.get(name)[2] += 1;
                answer = Math.max(answer, totalInfo.get(name)[2]);
            }
        }

        return answer;
    }
}