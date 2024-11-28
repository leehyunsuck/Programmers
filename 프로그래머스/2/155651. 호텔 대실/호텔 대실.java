import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;

        // book_time 을 정수 배열로 변환해서 입실 시간 기준으로 정렬
        int[][] bookTimeIntArr = new int[book_time.length][2];
        for (int idx = 0; idx < bookTimeIntArr.length; idx++) {
            String[] bt = book_time[idx];
            bookTimeIntArr[idx][0] = convertMinute(bt[0]);
            bookTimeIntArr[idx][1] = convertMinute(bt[1]);
        }
        Arrays.sort(bookTimeIntArr, (a1, a2) -> a1[0] - a2[0]);

        Queue<Integer> pQ = new PriorityQueue<>();
        for (int[] times : bookTimeIntArr) {
            if (!pQ.isEmpty() && times[0] >= pQ.peek()) pQ.poll();
            pQ.offer(times[1] + 10);
        }
        
        return pQ.size();
    }
    
    public int convertMinute(String time) {
        String[] split = time.split(":");
        
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}