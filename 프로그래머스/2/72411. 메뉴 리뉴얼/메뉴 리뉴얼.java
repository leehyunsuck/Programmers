import java.util.*;

class Solution {
    private int maxCount;
    
    public String[] solution(String[] orders, int[] course) {
        Set<String> newMenus = new TreeSet<>();
        
        for (int len : course) {
            this.maxCount = 0;
            Map<String, Integer> countCheck = new HashMap<>();
            for (String order : orders) {
                char[] menus = order.toCharArray();
                Arrays.sort(menus);
                makeNewMenu(countCheck, menus, len, "", 0); // 맵, 메뉴목록, 원하는길이, 세트메뉴명, 인덱스위치
            }
            
            if (this.maxCount < 2) continue;
            for (String newMenu : countCheck.keySet()) {
                if (countCheck.get(newMenu) == this.maxCount)
                    newMenus.add(newMenu);
            }
        }
        
        return newMenus.toArray(String[]::new);
    }
    
    public void makeNewMenu(Map<String, Integer> countCheck, char[] menus, int len, String newMenu, int idx) {
        if (newMenu.length() == len) {
            int count = countCheck.getOrDefault(newMenu, 0) + 1;
            countCheck.put(newMenu, count);
            this.maxCount = Math.max(this.maxCount, count);
            return;
        }
        
        for (int i = idx; i < menus.length; i++) 
            makeNewMenu(countCheck, menus, len, newMenu + menus[i], i + 1);
    }
}