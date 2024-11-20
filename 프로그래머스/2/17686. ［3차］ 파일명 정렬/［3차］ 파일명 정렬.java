import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String[] f1Split = this.split(f1),
                     f2Split = this.split(f2);
            
            int headSort = f1Split[0].compareToIgnoreCase(f2Split[0]);
            if (headSort != 0) return headSort;
            
            int numberSort = Integer.parseInt(f1Split[1]) - Integer.parseInt(f2Split[1]);
            return numberSort;
        });
        
        return files;
    }

    
    private String[] split(String file) {
        int headIdx   = -1,
            numberIdx = -1;

        for (int idx = 0; idx < file.length(); idx++) {
            if (numberIdx != -1) break;
            
            char c = file.charAt(idx);

            if (headIdx == -1) {
                if (Character.isDigit(c))   headIdx = idx - 1;
            } else if (numberIdx == -1) {
                if (!Character.isDigit(c))  numberIdx = idx - 1;
            }
        }
        
        String head   = file.substring(0, headIdx + 1),
               number = numberIdx == -1 ? file.substring(headIdx + 1) : file.substring(headIdx + 1, numberIdx + 1),
               tail   = numberIdx == -1 ? "" : file.substring(numberIdx + 1);
        
        return new String[] {head, number, tail};
    }
}