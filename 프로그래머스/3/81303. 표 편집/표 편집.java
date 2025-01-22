import java.util.*;

class Solution {
    // LinkedList 방식으로 풀이하려고
    private class Link {
        int prev;
        int next;
        
        Link(int prev, int next) {
            this.prev = prev;
            this.next = next;
        }
    }
    
    public String solution(int n, int k, String[] cmd) {
        Link[] table = new Link[n];
        resetTable(table, n);
        
        Stack<int[]> saveDelRowInfo = new Stack<>();
        int nowRow = k;
        
        for (String command : cmd)
            nowRow = runCmdController(table, saveDelRowInfo, command, nowRow);
        
        StringBuilder result = new StringBuilder();
        for (Link row : table)
            result.append(row.prev == row.next ? 'X' : 'O');
        
        return result.toString();
    }
    
    private int runCmdController(Link[] table, Stack<int[]> saveDelRowInfo, String command, int nowRow) {
        String[] cmdAndOption = command.split(" ");
        
        char cmd = cmdAndOption[0].charAt(0);
        int option = cmdAndOption.length > 1 ? Integer.parseInt(cmdAndOption[1]) : 0;
        
        if (cmd == 'C') return remove(table, saveDelRowInfo, nowRow);
        if (cmd == 'Z') return undo(table, saveDelRowInfo, nowRow);
        return move(table, nowRow, cmd, option);
    }
    
    private int move(Link[] table, int nowRow, char dir, int count) {
        while (count-- > 0)
            nowRow = (dir == 'U') ? table[nowRow].prev : table[nowRow].next;
        
        return nowRow;
    }
    
    private int undo(Link[] table, Stack<int[]> saveDelRowInfo, int nowRow) {
        int[] undoRowInfo = saveDelRowInfo.pop();
        
        int idx  = undoRowInfo[0],
            prev = undoRowInfo[1],
            next = undoRowInfo[2];
        
        if (prev != -1) table[prev].next = idx;
        if (next != -1) table[next].prev = idx;
        
        table[idx].prev = prev;
        table[idx].next = next;
        
        return nowRow;
    }
    
    private int remove(Link[] table, Stack<int[]> saveDelRowInfo, int nowRow) {
        int prev = table[nowRow].prev,
            next = table[nowRow].next;
        
        saveDelRowInfo.add(new int[] {nowRow, prev, next});
        
        if (prev != -1) table[prev].next = next;
        if (next != -1) table[next].prev = prev;
        
        table[nowRow].prev = -1;
        table[nowRow].next = -1;

        return next != -1 ? next : prev; 
    }
    
    private void resetTable(Link[] table, int n) {
        for (int idx = 0; idx < n; idx++)
            table[idx] = new Link(idx - 1, idx + 1);
        
        table[0].prev = -1;
        table[n -1].next = -1;
    }
}