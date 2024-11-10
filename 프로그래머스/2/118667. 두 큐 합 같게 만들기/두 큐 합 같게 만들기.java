import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long q1Sum = 0,
             q2Sum = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        for (int num : queue1) {
            q1.offer(num);
            q1Sum += num;
        }
        
        Queue<Integer> q2 = new LinkedList<>();
        for (int num : queue2) {
            q2.offer(num);
            q2Sum += num;
        }
        
        if ((q1Sum + q2Sum) % 2 != 0) return -1;
        
        int repeat = 0;
        int maxRepeat = (q1.size() + q2.size()) * 3;
        while (q1Sum != q2Sum && repeat < maxRepeat) {
            if (q1Sum > q2Sum) {
                int get = q1.poll();
                q2.offer(get);
                q1Sum -= get;
                q2Sum += get;
            } else {
                int get = q2.poll();
                q1.offer(get);
                q1Sum += get;
                q2Sum -= get;
            }
            repeat++;
        }
            
        return repeat == maxRepeat ? -1 : repeat;
    }
}