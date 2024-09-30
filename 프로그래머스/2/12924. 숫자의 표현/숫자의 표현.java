class Solution {
    public int solution(int n) {
        int answer = 1;
        for (int i = 1, sum = i; i <= n/2; i++, sum = i) 
            for (int j = i+1; sum < n; j++) if ((sum += j) == n) answer++;
        return answer;
    }
}

/*
int answer = 1;

for (int i = 1; i < n/2; i++) {
    int sum = i;
    
    for (int j = i+1; sum < n; j++) {
        sum += j;
        if (sum == n) answer++;
    }
}

return answer;
*/