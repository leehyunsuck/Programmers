import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        if (sameAll(arr)) {
            answer[arr[0][0]]++;
            return answer;
        }
        
        Queue<int[][]> queue = new LinkedList<>();
        quadSplitOffer(arr, queue);
    
        while (!queue.isEmpty()) {
            int[][] poll = queue.poll();
            
            // 더 이상 쪼갤 수 없음 (최소크기)
            if (poll.length == 1) {
                answer[poll[0][0]]++;
                continue;
            }

            if (sameAll(poll)) answer[poll[0][0]]++;    // 전체 같음
            else quadSplitOffer(poll, queue);           // 다르므로 분할
        }
        
        return answer;
    }
    
    /* 배열의 전체 값이 같은지 확인 */
    public boolean sameAll(int[][] arrs) {
        boolean result = true;
        
        int firstInt = arrs[0][0];
        for (int[] arr : arrs) {
            for (int num : arr) {
                if (firstInt == num) continue;
                result = false;
                break;
            }
        }
        
        return result;
    }
    
    /* 4 조각으로 분할하고 queue에 넣기 */
    public void quadSplitOffer(int[][] arr, Queue<int[][]> queue) {
        int midLen = arr.length / 2;
        
        int[][][] arrs = new int[4][midLen][midLen];
        for (int i = 0; i < midLen; i++) {
            for (int j = 0; j < midLen; j++) {
                arrs[0][i][j] = arr[i][j];
                arrs[1][i][j] = arr[i][j + midLen];
                arrs[2][i][j] = arr[i + midLen][j];
                arrs[3][i][j] = arr[i + midLen][j + midLen];
            }
        }
        
        for (int[][] array : arrs) {
            queue.offer(array);
        }
    }
}