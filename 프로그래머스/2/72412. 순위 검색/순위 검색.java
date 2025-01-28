import java.util.*;

class Solution {
    private Map<String, List<Integer>> infoTable = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        for (String dataQuery : info) {
            String[] data = dataQuery.split(" ");
            insertInfo(data, "", 0);
        }
        sortQueryMap();
        
        int[] answer = new int[query.length];
        for (int idx = 0; idx < query.length; idx++) {
            String[] selectQuery = query[idx].split(" ");
            
            StringBuilder queryBuilder = new StringBuilder();
            for (int i = 0; i < selectQuery.length; i += 2) {
                queryBuilder.append(selectQuery[i]);
            }
            answer[idx] = selectQueryCount(queryBuilder.toString(), Integer.parseInt(selectQuery[7]));
        }
        
        return answer;
    }
    
    // SELECT COUNT(*)
    private int selectQueryCount(String query, int minScore) {
        if (!infoTable.containsKey(query)) return 0;
        
        List<Integer> scores = infoTable.get(query);
        
        int left = 0, right = scores.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= minScore) right = mid;
            else left = mid + 1; 
        }
   
        return scores.size() - left;
    }
    
    private void sortQueryMap() {
        for (Map.Entry<String, List<Integer>> entry : infoTable.entrySet()) {
            Collections.sort(entry.getValue());
        }
    }
    
    // INSERT (모든 경우를 다 만들어서 저장)
    private void insertInfo(String[] data, String key, int idx) {
        if (idx == data.length - 1) {
            List<Integer> scores = infoTable.getOrDefault(key, new ArrayList<>());
            scores.add(Integer.parseInt(data[idx]));
            infoTable.put(key, scores);
            return;
        }
        
        insertInfo(data, key + data[idx], idx + 1);
        insertInfo(data, key + "-", idx + 1);
    }
}