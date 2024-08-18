class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        int oneIdx = 0, twoIdx = 0;
        for (String str : goal) {
            if (oneIdx < cards1.length && cards1[oneIdx].equals(str)) oneIdx++;
            else if (twoIdx < cards2.length && cards2[twoIdx].equals(str)) twoIdx++;
            else return "No";
        }
        return "Yes";
    }
}