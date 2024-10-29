class Solution {
    private int[] arr;
    private int target,
                result;
    
    public void setArr(int[] arr) {
        this.arr = arr;
    }
    
    public int getArrLen() {
        return this.arr.length;
    }
    
    public int getArrValue(int idx) {
        return this.arr[idx];
    }
    
    public void setTarget(int target) {
        this.target = target;
    }
    
    public int getTarget() {
        return this.target;
    }
    
    public void setResult(int result) {
        this.result = result;
    }
    
    public int getResult() {
        return this.result;
    }
    
    public void addOneResult() {
        this.result++;
    }
    
    public int solution(int[] numbers, int target) {
        this.setArr(numbers);
        this.setTarget(target);
        this.setResult(0);
        
        this.dfs(0, 0);
        
        return this.getResult();
    }
    
    public void dfs(int idx, int sum) {
        if (idx == this.getArrLen()) {
            if (sum == this.getTarget())
                this.addOneResult();
            return;
        }
        
        this.dfs(idx + 1, sum + getArrValue(idx));
        this.dfs(idx + 1, sum - getArrValue(idx));
    }
}

/*  
메모리: 85.9 MB, 시간: 5.22 ms

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

*/