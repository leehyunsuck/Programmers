import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        // 최소성 + 유일성 지키는 키 저장
        List<List<Integer>> keys = new ArrayList<>();
        
        for (int count = 1; count <= relation[0].length; count++) {
            List<List<Integer>> numOfCases = new ArrayList<>();
            dfs(numOfCases, new ArrayList<>(), 0, relation[0].length - 1, count);
            
            for (List<Integer> key : numOfCases) {
                if (!isMin(key, keys) || !isUnique(relation, key)) continue;
                keys.add(key);
            }
        }
        return keys.size();
    }
    
    // 유일성 체크
    private boolean isUnique(String[][] relations, List<Integer> key) {
        Set<String> set = new HashSet<>();
        
        for (String[] relation : relations) {
            StringBuilder builder = new StringBuilder();
            
            for (int idx : key) 
                builder.append(relation[idx]);
            
            if (!set.add(builder.toString())) return false;
        }
        return true;
    }
    
    // 최소성 체크
    private boolean isMin(List<Integer> key, List<List<Integer>> keys) {
        for (List<Integer> saveKey : keys) {
            if (key.containsAll(saveKey)) return false;
        }
        return true;
    }
    
    // 조합할 속성 인덱스 생성
    private void dfs(List<List<Integer>> numOfCases, List<Integer> cases,
                     int startIdx, int maxIdx, int count) {
        if (cases.size() == count) {
            numOfCases.add(new ArrayList<>(cases));
            return;
        }
        
        for (int idx = startIdx; idx <= maxIdx; idx++) {
            cases.add(idx);
            dfs(numOfCases, cases, idx + 1, maxIdx, count);
            cases.remove(cases.size() - 1);
        }
    }
}

// 유일성 및 최소성 지키는 후보키의 개수