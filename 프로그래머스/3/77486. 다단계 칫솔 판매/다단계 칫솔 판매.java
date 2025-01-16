import java.util.*;

class Solution {
    // 다단계 (판매원, 추천인, 수익)
    class MLM {
        private String name;
        private MLM inviter;
        private int cost;
    
        public MLM(String name) {
            this.name = name;
            this.inviter = null;
            this.cost = 0;
        }
        
        public void setInviter(MLM inviter) {
            this.inviter = inviter;
        }
        
        public int getCost() {
            return cost;
        }
        
        public void calCost(int cost) {
            int inviterCost = (int) (cost * 0.1);
            int sellerCost  = cost - inviterCost;
            
            this.cost += sellerCost;
            
            if (inviter == null || inviterCost == 0) return;
            inviter.calCost(inviterCost);
        }
    }
    
    private static int ONE_COST = 100;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 판매원 : 다단계 객체
        Map<String, MLM> mlmMap = new HashMap<>();
        resetMLMMap(mlmMap, enroll, referral);
        calCosts(mlmMap, seller, amount);
        
        return changeMLMMapToArrOrderArr(mlmMap, enroll);
    }
    
    private int[] changeMLMMapToArrOrderArr(Map<String, MLM> map, String[] orders) {
        int[] result = new int[orders.length];
        
        for (int idx = 0; idx < result.length; idx++) {
            result[idx] = map.get(orders[idx]).getCost();
        }
        
        return result;
    }
    
    private void calCosts(Map<String, MLM> map, String[] seller, int[] amount) {
        for (int idx = 0; idx < seller.length; idx++) {
            map.get(seller[idx]).calCost(amount[idx] * ONE_COST);
        }
    }
    
    private void resetMLMMap(Map<String, MLM> map, String[] names, String[] inviters) {
        for (String name : names) {
            map.put(name, new MLM(name));
        }
        
        for (int idx = 0; idx < names.length; idx++) {
            String name = names[idx],
                   inviter = inviters[idx];
            
            if (inviter.equals("-")) continue;
            map.get(name).setInviter(map.get(inviter));
        }
    }
}