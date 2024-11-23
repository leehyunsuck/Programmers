// 이번 문제로 얻은 지식
// set에 넣는건 {1, 0} 이라는 같은 값이여도 다른 객체면 중복처리가 안됨

import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;

        char[][] boards = new char[m][n];               // 이중 배열로 해서 접근하기 쉽게
        for (int i = 0; i < m; i++)
            boards[i] = board[i].toCharArray();

        while (true) {
            Set<String> removeSet = new HashSet<>();    // 지울 좌표 저장
            
            for (int row = 0; row < m - 1; row++) {     // 2*2 같은 블럭 찾기 시작
                for (int col = 0; col < n - 1; col++) {
                    char c = boards[row][col];
                    
                    if (c == ' ') continue;             // 빈공간임
                    
                    int[][] rowCols = {                 // 우, 하, 우하 확인
                        {row, col}, {row, col + 1},
                        {row + 1, col}, {row + 1, col + 1}
                    };

                    boolean can = true;
                    for (int[] rc : rowCols) {          // 위 좌표들 같은 블럭인지 판단
                        if (boards[rc[0]][rc[1]] == c) continue;
                        can = false;
                        break;
                    }
                    
                    if (!can) continue;                 // 같은 블럭 아님 (안지움)
      
                    for (int[] rc : rowCols)            // 같은 블럭이므로 지울 정보에 저장
                        removeSet.add(rc[0] + "," + rc[1]);
                }   // [for] [col] - end
            }       // [for] [row] - end
            if (removeSet.size() == 0) break;           // 지울 블럭 없으면 반복 멈춤
            
            answer += removeSet.size();
            for (String info : removeSet) {             // 블럭 지우기
                String[] removeRC = info.split(",");
                boards[Integer.parseInt(removeRC[0])][Integer.parseInt(removeRC[1])] = ' ';
            }
            
            for (int col = 0; col < n; col++) {         // 아래 빈 공간들 채우기 (블럭 떨구기)
                /*
                     나는 boards의 맨 아래 블럭부터 위로 조회하면서
                    블럭이면 새로운 임시 배열에 넣고,
                    빈공간이면 임시 배열 마지막쪽에 빈 문자열 넣음.
                     그렇게 새로운 배열을 기존 boards에 넣음
                */
                char[] temp = new char[m];

                for (int row = m - 1, tempIdx = 0, tempBackIdx = m - 1; row >= 0; row--) {
                    if (boards[row][col] == ' ') {
                        temp[tempBackIdx--] = ' ';
                        continue;
                    }
                    temp[tempIdx++] = boards[row][col];
                }

                for (int row = m - 1, i = 0; row >= 0; row--, i++)
                    boards[row][col] = temp[i];
            }   // [for] [빈공간채우기] - end
        }       // [while] - end
        return answer;
    }
}