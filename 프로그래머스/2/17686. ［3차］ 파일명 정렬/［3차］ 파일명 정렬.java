import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (f1, f2) -> {
            String[] f1Split = this.fileSplit(f1),
                     f2Split = this.fileSplit(f2);
            
            int headSort = f1Split[0].compareToIgnoreCase(f2Split[0]);
            if (headSort != 0) return headSort;
            
            return Integer.compare(Integer.parseInt(f1Split[1]), Integer.parseInt(f2Split[1]));
        });
        
        return files;
    }
    
    public String[] fileSplit(String file) {
        int headLastIdx = -1,
            numberLastIdx = -1;
        
        for (int idx = 0; idx < file.length(); idx++) {
            char c = file.charAt(idx);
            
            if (headLastIdx == -1) {
                if (Character.isDigit(c))
                    headLastIdx = idx - 1;
            } else if (!Character.isDigit(c)) {
                numberLastIdx = idx - 1;
                break;
            }
        }
        
        if (numberLastIdx == -1)             numberLastIdx = headLastIdx + 5;
        if (numberLastIdx >= file.length())  numberLastIdx = file.length() - 1;
        if (numberLastIdx - headLastIdx > 5) numberLastIdx = headLastIdx + 5; 
        
        String head = file.substring(0, headLastIdx + 1),
               num  = file.substring(headLastIdx + 1, numberLastIdx + 1),
               tail = numberLastIdx == file.length() - 1 ? "" : file.substring(numberLastIdx + 1);
        
        return new String[] {head, num, tail};
    }
}