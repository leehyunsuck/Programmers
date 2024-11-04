import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for (int idx = 0; idx < nums.length; idx++)
            nums[idx] = String.valueOf(numbers[idx]);
        
        Arrays.sort(nums, (a, b) -> (b+a).compareTo(a+b));
        
        StringBuilder answer = new StringBuilder();
        for (String num : nums)
            answer.append(num);
        
        if (answer.charAt(0) == '0') return "0";
        
        return answer.toString();
    }
    
//     public void sort(int[] numbers) {
//         StringBuilder   maxStr = null,
//                         subStr = null;
        
//         for (int fIdx = 0; fIdx < numbers.length; fIdx++) {
//             int maxIdx = fIdx;
            
//             maxStr = new StringBuilder(String.valueOf(numbers[maxIdx]));
//             for (int i = 4 - maxStr.length(); i > 0; i--)
//                 maxStr.append("0");
            
//             for (int sIdx = fIdx + 1; sIdx < numbers.length; sIdx++) {
//                 subStr = new StringBuilder(String.valueOf(numbers[sIdx]));

//                 for (int i = 4 - subStr.length(); i > 0; i--)
//                     subStr.append("0");
                
//                 boolean change = false;
//                 for (int cIdx = 0; cIdx < 4; cIdx++) {
//                     char mC = maxStr.charAt(cIdx),
//                          sC = subStr.charAt(cIdx);
                    
//                     if (sC == mC) {
//                         if (sC != '0') continue;
//                         if (numbers[sIdx] < numbers[maxIdx]) change = true;
//                     }
//                     if (sC > mC) change = true;
//                     break;
//                 }
//                 if (change) {
//                     maxIdx = sIdx;
//                     maxStr = new StringBuilder(String.valueOf(numbers[maxIdx]));
//                     for (int i = 4 - maxStr.length(); i > 0; i--)
//                         maxStr.append("0");
//                 }
//             }
            
//             if (maxIdx == fIdx) continue;
            
//             int temp = numbers[fIdx];
//             numbers[fIdx] = numbers[maxIdx];
//             numbers[maxIdx] = temp;
//         }
//     }
}