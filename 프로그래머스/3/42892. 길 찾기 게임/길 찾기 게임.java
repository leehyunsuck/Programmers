import java.util.*;

class Solution {
    private class Node {
        int x, y, name;
        Node[] childs;
        
        Node(int[] nodeInfo) {
            this.x = nodeInfo[0];
            this.y = nodeInfo[1];
            this.name = nodeInfo[2];
            this.childs = new Node[2];
        }
        
        void addNode(Node child) {
            int location = child.x < this.x ? 0 : 1;
            if (this.childs[location] == null) this.childs[location] = child;
            else this.childs[location].addNode(child);
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int nodeCount = nodeinfo.length;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>( (a1, a2) -> {
            int compare = a2[1] - a1[1];
            if (compare != 0) return compare;   // y를 기준으로 내림차순
            return a1[0] - a2[0];               // x를 기준으로 오름차순
        });
        
        for (int idx = 0; idx < nodeCount; idx++)
            queue.offer(new int[] { nodeinfo[idx][0], nodeinfo[idx][1], idx + 1 });

        Node root = new Node(queue.poll());
        while (!queue.isEmpty()) 
            root.addNode(new Node(queue.poll()));
        
        List<Integer> preNames = new ArrayList<>(),
                      postNames = new ArrayList<>();
        
        preVisit(preNames, root);
        postVisit(postNames, root);
        
        int[][] result = new int[2][preNames.size()];
        result[0] = listToArray(preNames);
        result[1] = listToArray(postNames);
        
        return result;
    }
    
    // 스트림보다 직접 하는게 더 빠름
    private int[] listToArray(List<Integer> list) {
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) 
            result[i] = list.get(i);
        return result;
    }
    
    // 전위
    private void preVisit(List<Integer> names, Node node) {
        if (node == null) return;
        names.add(node.name);
        preVisit(names, node.childs[0]);
        preVisit(names, node.childs[1]);
    }
    
    // 중위
    private void inVisit(List<Integer> names, Node node) {
        if (node == null) return;
        inVisit(names, node.childs[0]);
        names.add(node.name);
        inVisit(names, node.childs[1]);
    }
    
    // 후위
    private void postVisit(List<Integer> names, Node node) {
        if (node == null) return;
        postVisit(names, node.childs[0]);
        postVisit(names, node.childs[1]);
        names.add(node.name);
    }
}