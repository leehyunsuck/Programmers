import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 노래장르 : 내림차순 재생횟수 (가장 큰 값은 전체 합)
        Map<String, List<int[]>> infoMap = new HashMap<>();
        Map<String, Integer> totalMap = new HashMap<>();
        
        for (int idx = 0; idx < genres.length; idx++) {
            String key = genres[idx];
            int[] value = new int[] {plays[idx], idx};
            
            List<int[]> list = infoMap.getOrDefault(key, new ArrayList<>());
            list.add(value);
            infoMap.put(key, list);
            
            totalMap.put(key, totalMap.getOrDefault(key, 0) + value[0]);
        }
        
        // 큰 값부터 정렬하는 용도
        List<Map.Entry<String, Integer>> entry = new ArrayList<>(totalMap.entrySet());
        entry.sort( (e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        // 큰 값부터 노래장르를 리스트에 넣음
        // 추가로 [노래재생횟수, 인덱스] 를 노래재생횟수가 큰 값부터, 같다면 인덱스가 작은 값부터 정렬
        List<String> keys = new ArrayList<>();
        for (Map.Entry<String, Integer> e : entry) {
            keys.add(e.getKey());
            
            List<int[]> list = infoMap.get(e.getKey());
            list.sort( (a1, a2) -> {
                int a1Count = a1[0],
                    a2Count = a2[0],
                    a1Idx = a1[1],
                    a2Idx = a2[1];
                
                int compare = a2Count - a1Count;
                if (compare != 0) return compare;
                return a1Idx - a2Idx;
            });
        }
        
        List<Integer> answerList = new ArrayList<>();
        for (String key : keys) {
            List<int[]> list = infoMap.get(key);
            
            for (int i = 0; i < Math.min(list.size(), 2); i++) {
                answerList.add(list.get(i)[1]);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int idx = 0; idx < answer.length; idx++) {
            answer[idx] = answerList.get(idx);
        }
        
        return answer;
    }
}

// 이렇게 푸는게 맞나? 너무 어렵게 푸는것같은데;;