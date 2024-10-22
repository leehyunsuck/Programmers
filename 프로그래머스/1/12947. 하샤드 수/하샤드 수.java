class Solution {
    public boolean solution(int x) {
        int sum = 0;
        for (char c : String.valueOf(x).toCharArray()) {
            sum += c - '0';
        }
        
        return x % sum == 0;
    }
}

// 반복문으로 나눠서 더함 -> 메모리: 80.1 MB, 시간: 0.04 ms