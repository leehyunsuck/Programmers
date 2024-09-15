import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] failCount = new int[N];
        for (int stage : stages) 
            if (stage <= N) failCount[stage-1]++;

        double[] failRate = new double[N];
        double totalPeople = stages.length;
        
        for (int i = 0; i < N; i++) {
            failRate[i] = failCount[i] > 0 ? failCount[i] / totalPeople : 0.0;
            totalPeople -= failCount[i];
        }
        
        int[] answer = new int[N];
        double[] copy = Arrays.copyOf(failRate, failRate.length);
        Arrays.sort(copy);
        
        int index = 0;
        double temp = -1.0;
        for (int i = copy.length - 1; i >= 0; i--) {
            if (temp == copy[i]) continue;
            else temp = copy[i];
            
            for (int j = 0; j < answer.length; j++) {
                if (index >= answer.length) break;
                if (temp == failRate[j]) answer[index++] = j + 1;
            }
        }
        
        return answer;
    }
}