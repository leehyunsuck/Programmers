class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        int max = Integer.MIN_VALUE,
            min = Integer.MAX_VALUE;
        
        for (int i = 0; i < split.length; i++) {
            int num = Integer.parseInt(split[i]);
            if (num > max) max = num;
            if (num < min) min = num;
        }
        
        String answer = min + " " + max;
        return answer;
    }
}