import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answerL = new ArrayList<>();

        for (int len : course) {                                // 특정 개수 만큼 조합이 필요함
            Map<String, Integer> orderCount = new HashMap<>();  // 메뉴조합 : 주문개수
            for (String order : orders) {                       // 기존 주문 기록을 토대로 조회
                char[] menus = order.toCharArray();
                Arrays.sort(menus);
                makeAndPut(orderCount, menus, "", len, 0);
            }
            Set<String> mostOrderMenu = findMostOrder(orderCount, 2);   // 가장 많이 주문된 메뉴 조합 찾고
            answerL.addAll(mostOrderMenu);                              // answer List에 저장
        }

        String[] answer = answerL.toArray(new String[0]);
        Arrays.sort(answer);
        
        return answer;
    }
    
    // 조합 가능한 메뉴 찾기
    // (메뉴조합 : 주문개수) , 메뉴목록, 새로운_메뉴_조합, 필요_메뉴_개수, 어디까지_메뉴는_사용했는지
    public void makeAndPut(Map<String, Integer> map, char[] menus, String newMenu, int len, int minIdx) {
        if (newMenu.length() == len) {
            map.put(newMenu, map.getOrDefault(newMenu, 0) + 1);
            return;
        }
        
        for (int i = minIdx; i < menus.length; i++)
            makeAndPut(map, menus, newMenu + menus[i], len, i + 1);
    }
    
    // 가장 많이 주문된 메뉴 찾기
    // (메뉴조합 : 주문개수) , 가장_많이_주문된_메뉴조합의_개수
    public Set<String> findMostOrder(Map<String, Integer> map, int maxValue) {
        Set<String> set = new HashSet<>();
        
        for (String key : map.keySet()) {
            int value = map.get(key);
            
            if (value < maxValue) continue;
            if (value > maxValue) {
                set = new HashSet<>();
                maxValue = value;
            }
            set.add(key);
        }
        
        return set;
    }
}