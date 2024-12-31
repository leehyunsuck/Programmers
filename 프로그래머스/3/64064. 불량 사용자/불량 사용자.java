import java.util.*;

class Solution {
    public int solution(String[] userId, String[] bannedId) {
        // id길이 : id들 -> banMap 추가용
        Map<Integer, List<String>> idMap = new HashMap<>();
        resetIdMap(idMap, userId);
        
        // 가려진BanId : 매칭되는 id들
        Map<String, List<String>> banMap = new HashMap<>();
        resetBanMap(banMap, bannedId, idMap);
        
        Set<String> usedSet = new HashSet<>();
        
        Set<Set<String>> findSet = new HashSet<>();
        resetFindSet(findSet, banMap, usedSet, bannedId, new HashSet<>(), 0);
        
        return findSet.size();
    }
    
    private void resetFindSet(Set<Set<String>> findSet,
                              Map<String, List<String>> banMap,
                              Set<String> usedSet,
                              String[] bannedId,
                              Set<String> set,
                              int idx) {
        if (idx == bannedId.length) {
            Set<String> copy = new HashSet<>(set);
            findSet.add(copy);
            return;
        }

        for (String id : banMap.get(bannedId[idx])) {
            if (usedSet.contains(id)) continue;

            set.add(id);
            usedSet.add(id);
            resetFindSet(findSet, banMap, usedSet, bannedId, set, idx + 1);
            set.remove(id);
            usedSet.remove(id);
        }
    }
    
    private boolean isMatch(String secretId, String id) {
        for (int idx = 0; idx < secretId.length(); idx++) {
            char secretIdChar = secretId.charAt(idx);
            if (secretIdChar == '*') continue;
            
            char idChar = id.charAt(idx);
            if (secretIdChar != idChar) return false;
        }
        
        return true;
    }
    
    private void resetBanMap(Map<String, List<String>> banMap, String[] bannedId,
                             Map<Integer, List<String>> idMap) {
        for (String ban : bannedId) {
            int banIdLen = ban.length();
            
            List<String> matchs = new ArrayList<>();
            for (String id : idMap.getOrDefault(banIdLen, new ArrayList<>())) {
                if (!isMatch(ban, id)) continue;
                matchs.add(id);
            }
            
            banMap.put(ban, matchs);
        }
    }
    
    private void resetIdMap(Map<Integer, List<String>> idMap, String[] ids) {
        for (String id : ids) {
            int idLen = id.length();
            
            List<String> list = idMap.getOrDefault(idLen, new ArrayList<>());
            list.add(id);
            
            idMap.put(idLen, list);
        }
    }
}