import java.util.*;

class Solution {
    class PathList {
        private ArrayList<String> pathList;
        private Map<String, ArrayList<String>> pathMap;
        
        public PathList(ArrayList<String> pathList, Map<String, ArrayList<String>> pathMap) {
            this.pathList = pathList;
            this.pathMap = pathMap;
        }
        
        public ArrayList<String> copyPathList() {
            ArrayList<String> newPathList = new ArrayList<>();
            for (String path : pathList) {
                newPathList.add(path);
            }
            return newPathList;
        }
        
        public Map<String, ArrayList<String>> copyPathMap() {
            Map<String, ArrayList<String>> newMap = new HashMap<>();
            for (Map.Entry<String, ArrayList<String>> entry : pathMap.entrySet()) {
                newMap.put(entry.getKey(), new ArrayList<>(entry.getValue()));
            }
            return newMap;
        }
        
        public String lastValue() {
            return pathList.get(pathList.size() - 1);
        }
        
        public int getSize() {
            return pathList.size();
        }
        
        public String[] toArray() {
            return pathList.toArray(new String[0]);
        }
    }
    
    public String[] solution(String[][] tickets) {
        // 가능 경로가 2개 이상 -> 알파벳 순서가 앞서는 경로 (정렬)
        Map<String, ArrayList<String>> pathMap = createPathMap(tickets);

        PathList pathList = findFollowRuleFirstPathListBFS(pathMap, tickets.length + 1);
        
        return pathList == null ? new String[0] : pathList.toArray();
    }
    
    private PathList findFollowRuleFirstPathListBFS(Map<String, ArrayList<String>> pathMap, int maxSize) {
        Queue<PathList> queue = new LinkedList<>();
        ArrayList<String> startList = new ArrayList<>();
        startList.add("ICN");
        queue.offer(new PathList(startList, pathMap));
        
        while (!queue.isEmpty()) {
            PathList poll = queue.poll();
            
            if (poll.getSize() == maxSize)
                return poll;
            
            String now = poll.lastValue();
            
            ArrayList<String> nextPaths = poll.copyPathMap().getOrDefault(now, new ArrayList<>());
            
            for (int idx = 0; idx < nextPaths.size(); idx++) {
                ArrayList<String> list = poll.copyPathList();
                Map<String, ArrayList<String>> map = poll.copyPathMap();
                list.add(map.get(now).remove(idx));
                
                queue.offer(new PathList(list, map));
            }
        }
        
        return null;
    }
    
    private Map<String, ArrayList<String>> createPathMap(String[][] tickets) {
        Map<String, ArrayList<String>> resultMap = new HashMap<>();
        
        for (String[] ticket : tickets) {
            resultMap.putIfAbsent(ticket[0], new ArrayList<>());
            resultMap.get(ticket[0]).add(ticket[1]);
        }
        
        for (String key : resultMap.keySet()) {
            Collections.sort(resultMap.get(key));
        }
        
        return resultMap;
    }
}

