import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        List<String> str1List = new ArrayList<>(),
                     str2List = new ArrayList<>();
        
        this.addList(str1List, str1);
        this.addList(str2List, str2);
        
        for (String s : str1List) {
            System.out.print(s + " ");
        }
        System.out.println("");
        for (String s : str2List) {
            System.out.print(s + " ");
        }
        
        int sameCount = this.sameSetCount(str1List, str2List);
        int listCount = str1List.size() + str2List.size();
            
        // 합집합이 공집합이면
        if (listCount - sameCount == 0) return 65536; 

        double jakad = (double) sameCount / (listCount - sameCount);

        return (int) (65536 * jakad);
    }
    
    // 교집합
    public int sameSetCount(List<String> list1, List<String> list2) {
        int result = 0;
        
        // 종류 : 개수
        Map<String, Integer> map = new HashMap<>();
        
        for (String str : list1) {
            int count = map.getOrDefault(str, 0);
            map.put(str, count + 1);
        }
        
        for (String str : list2) {
            if (!map.containsKey(str)) continue;
            int count = map.get(str) - 1;
            result++;
            
            if (count == 0) map.remove(str);
            else map.put(str, count);
        }
        
        return result;
    }
    
    public void addList(List<String> list, String str) {
        String strUpper = str.toUpperCase();
        
        for (int i = 0; i < strUpper.length() - 1; i++) {
            String addStr = strUpper.substring(i, i+2);
            
            boolean pass = false;
            for (char c : addStr.toCharArray()) {
                if (c >= 'a' && c <= 'z') continue;
                if (c >= 'A' && c <= 'Z') continue;
                pass = true;
                break;
            }
            if (pass) continue;
            
            list.add(addStr);
        }
    }
}