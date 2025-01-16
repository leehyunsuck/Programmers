import java.util.*;

class Solution {
    // 다단계 (판매원, 추천인, 수익)
    class MLM {
        private String name;
        private String inviterName;
        private int cost;
    
        public MLM(String name, String inviterName) {
            this.name = name;
            this.inviterName = inviterName;
            this.cost = 0;
        }
        
        public void addCost(int cost) {
            this.cost += cost;
        }
        
        public String getInviterName() {
            return inviterName;
        }
        
        public int getCost() {
            return cost;
        }
    }
    
    private static int oneCost = 100;
    
    /**
     * 다단계 이익 최종 결과
     * 추천인 10%, 판매원 90%의 수익
     * 추천인 수익도 다단계 구조
     * 1원 미만은 분배하지 않음 ex) 10%금액이 0.8이면 판매자가 가짐
     *
     * @param enroll    판매원 이름 배열
     * @param referral  해당 판매원을 영입한 판매원
     *                  "-" : 추천없이
     *                  enroll의 같은 인덱스 판매원을 영입시킨 사람
     * @param seller    판매 데이터 판매원 이름
     * @param amount    판매 데이터 판매한 수량
     * @return          각 판매원이 득한 이익금 enroll 순서로 나열
     */
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 판매원 : 다단계 객체
        Map<String, MLM> mlmMap = new HashMap<>();
        resetMLMMap(mlmMap, enroll, referral);
        calCost(mlmMap, seller, amount);
        
        return changeMLMMapToArrOrderArr(mlmMap, enroll);
    }
    
    private int[] changeMLMMapToArrOrderArr(Map<String, MLM> map, String[] orders) {
        int[] result = new int[orders.length];
        
        for (int idx = 0; idx < result.length; idx++) {
            result[idx] = map.get(orders[idx]).getCost();
        }
        
        return result;
    }
    
    private void calCost(Map<String, MLM> mlmMap, String[] seller, int[] amount) {
        for (int idx = 0; idx < seller.length; idx++) {
            String name = seller[idx];
            int cost = amount[idx] * oneCost;

            while (true) {
                int inviterCost = (int) (cost * 0.1),   // 10%
                    sellerCost  = cost - inviterCost;   // 90%
                
                MLM sellerMLM = mlmMap.get(name);
                sellerMLM.addCost(sellerCost);
                
                name = sellerMLM.getInviterName();
                cost = inviterCost;
                
                // inviterCost가 1원 미만이거나, inviter가 "-"이면 멈춤
                if (inviterCost == 0 || name.equals("-")) break;
            }
        }
    }
    
    private void resetMLMMap(Map<String, MLM> map, String[] names, String[] inviters) {
        for (int idx = 0; idx < names.length; idx++) {
            String name = names[idx],
                   inviterName = inviters[idx];
            map.put(name, new MLM(name, inviterName));
        }
    }
}