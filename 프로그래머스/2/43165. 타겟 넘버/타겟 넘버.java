class Solution {
    public int solution(int[] numbers, int target) {
        return this.dfs(numbers, target, 0, 0);
    }
    
    public int dfs(int[] arr, int target, int idx, int sum) {
        if (idx == arr.length) {
            if (sum == target) 
                return 1;
            return 0;
        }
        
        return  this.dfs(arr, target, idx + 1, sum + arr[idx]) +
                this.dfs(arr, target, idx + 1, sum - arr[idx]);
    }
}