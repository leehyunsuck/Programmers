class Solution {
    
    //최대 체력 넘지 않게 회복
    public int heal(int max, int add, int health) {
        health += add;
        if (health > max) health = max;
        return health;
    }
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        //최대 체력
        int maxHealth = health;
        
        //공격 인덱스 번호
        int attackIdx = 0;
        
        //연속 회복 수치
        int healCount = 0;
        
        //마지막 공격 직후까지 반복
        for(int i = 1; i <= attacks[attacks.length - 1][0]; i++) {
            
            //공격 확인
            if (attacks[attackIdx][0] == i) {
                health -= attacks[attackIdx++][1];
                healCount = 0;
                //System.out.println("[공격] 체력 : " + health);
                
                //종료 설정
                if (health <= 0) break;
            } else {
                //1초 체력 회복량
                health = heal(maxHealth, bandage[1], health);
                healCount++;
                //System.out.println("[회복] 체력 : " + health);
                
                //추가 회복 확인
                if (healCount == bandage[0]) {
                    healCount = 0;
                    health = heal(maxHealth, bandage[2], health);
                    //System.out.println("[추가회복] 체력 : " + health);
                }
            }
        }
        
        return health > 0 ? health : -1;
    }
    

}

