class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int count = 0;
                    for (int a = 1; a * a <= sum; a++) {
                        if (sum % a == 0) {
                            count++;
                            if (sum / a != a) count++;
                            if (count > 2) break;
                        }
                    }
                    if (count == 2) answer++;
                }
            }
        }

        return answer;
    }
}