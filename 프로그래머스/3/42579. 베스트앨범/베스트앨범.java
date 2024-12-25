import java.util.*;

class Solution {
    class Unit {
        private int idx;
        private int value;
        
        public Unit(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
        
        public int getIdx() {
            return idx;
        }
        
        public int getValue() {
            return value;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreAllPlayCount = new HashMap<>();
        Map<String, List<Unit>> unitMap = new HashMap<>();

        resetFieldMap(genres, plays, genreAllPlayCount, unitMap);
        sortUnitMap(unitMap);

        int[] answer = getResult(genreAllPlayCount, unitMap);
        
        return answer;
    }

    public int[] getResult(Map<String, Integer> gMap, Map<String, List<Unit>> uMap) {
        List<Integer> resultList = new ArrayList<>();

        for (String key : getSortedKeyList(gMap)) {
            List<Unit> unitList = uMap.get(key);

            for (int i = 0; i < Math.min(unitList.size(), 2); i++) {
                resultList.add(unitList.get(i).getIdx());
            }
        }

        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }

    public void sortUnitMap(Map<String, List<Unit>> map) {
        for (String key : map.keySet()) {
            List<Unit> list = map.get(key);
            list.sort( (u1, u2) -> {
                int compare = u2.getValue() - u1.getValue();
                if (compare != 0) return compare;
                return u1.getIdx() - u2.getIdx();
            });
        }
    }

    public List<String> getSortedKeyList(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort( (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            result.add(entry.getKey());
        }

        return result;
    }

    public void resetFieldMap(String[] genres, int[] plays, Map<String, Integer> genreAllPlayCount, Map<String, List<Unit>> unitMap) {
        for (int idx = 0; idx < genres.length; idx++) {
            String key = genres[idx];
            int count = plays[idx];

            List<Unit> list = unitMap.getOrDefault(key, new ArrayList<>());
            list.add(new Unit(idx, count));
            unitMap.put(key, list);

            genreAllPlayCount.put(key, genreAllPlayCount.getOrDefault(key, 0) + count);
        }
    }
}

// 이렇게 푸는게 맞나? 너무 어렵게 푸는것같은데;;