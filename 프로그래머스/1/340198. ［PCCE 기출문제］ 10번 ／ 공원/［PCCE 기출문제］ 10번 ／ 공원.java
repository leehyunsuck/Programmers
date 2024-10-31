import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        Arrays.sort(mats);
        Queue<Integer> matQueue = new LinkedList<>();
        for (int mat : mats)
            matQueue.add(mat);
        
        for (int i = 0; i < park.length && !matQueue.isEmpty(); i++)
            for (int j = 0; j < park[i].length && !matQueue.isEmpty(); j++) 
                canPlace(i, j, matQueue, park);
        
        if (matQueue.size() == mats.length) return -1;
        if (matQueue.size() == 0) return mats[mats.length - 1];
        
        int peek = matQueue.peek(); // 이거 전 꺼만 있음
        
        for (int i = 0; i < mats.length; i++) 
            if (peek == mats[i + 1]) return mats[i];
        
        return -1;
    }
    
    public void canPlace(int row, int column, Queue<Integer> mat, String[][] park) {
        while (!mat.isEmpty()) {
            int len = mat.peek();
            
            if (row + len > park.length || column + len > park[row].length) break;
            
            boolean check = true;
            for (int r = row; r < row + len; r++) {
                for (int c = column; c < column + len; c++) {
                    if (park[r][c].equals("-1")) continue;
                    check = false;
                    break;
                }
                if (!check) break;
            }
            
            if (check) mat.remove();
            else break;
        }
    }
}