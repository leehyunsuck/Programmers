import java.util.*;

class Solution {
    // 숫자Queue, 연산자Queue, 연산자개수Map, 연산자List 초기화
    public void resetInfo(String expression, Queue<Long> numsQ, Queue<Character> operatorsQ,
                          char[] operators, List<String> orders) {
        List<Character> operatorList = new ArrayList<>();
        for (char operator : operators) operatorList.add(operator);
        
        StringBuilder numBuilder = new StringBuilder();
        
        for (char c : expression.toCharArray()) {
            if (!operatorList.contains(c)) numBuilder.append(c);
            else {
                numsQ.offer(Long.parseLong(numBuilder.toString()));
                operatorsQ.offer(c);
                numBuilder.setLength(0);
            }
        }
        numsQ.offer(Long.parseLong(numBuilder.toString()));
        
        addOrders(orders, operatorList, 0);
    }
    
    // 연산자 조합 가능한 모든 경우 추가
    public void addOrders(List<String> orders, List<Character> operatorList, int minIdx) {
        if (minIdx == operatorList.size()) {
            orders.add(operatorList.toString());
            return;
        }
        
        for (int i = minIdx; i < operatorList.size(); i++) {
            Collections.swap(operatorList, i, minIdx);
            addOrders(orders, operatorList, minIdx + 1);
            Collections.swap(operatorList, i, minIdx);
        }
    }
    
    // 우선순위에 따라 계산된 값   *** 여기 좀 많이 어려웠음 ***
    public long getLongToInfo(Queue<Long> nQ, Queue<Character> oQ, String order) {
        // 문자열로 들어온 연산자 순서를 배열에 넣음
        String[] split = order.replace("[", "").replace("]", "").split(", ");
        char[] operOrders = new char[split.length];
        for (int idx = 0; idx < operOrders.length; idx++) {
            operOrders[idx] = split[idx].trim().charAt(0);
        }
       
        // 연산자 우선순위대로 계산
        for (char operator : operOrders) {
            // 순서는 유지해야하므로 임시 Queue 만들고 사용
            Queue<Long> tempNQ = new LinkedList<>();
            Queue<Character> tempOQ = new LinkedList<>();
            
            Long num1 = nQ.poll();
            while (!oQ.isEmpty()) {
                char oper = oQ.poll();
                Long num2 = nQ.poll();
                
                if (oper == operator) {
                    switch (oper) {
                        case '*':
                            num1 *= num2;
                            break;
                        case '+':
                            num1 += num2;
                            break;
                        case '-':
                            num1 -= num2;
                            break;
                        default:
                            System.out.println("Not Found Operator to getLongToInfo()");
                    }
                } else {
                    // 우선순위 연산자가 아니므로 순서 유지되게끔 임시 공간에 넣기
                    tempNQ.offer(num1);
                    tempOQ.offer(oper);
                    num1 = num2;
                }
            } // while - !연산자Queue.isEmpty()
            tempNQ.offer(num1);
            nQ = tempNQ;
            oQ = tempOQ;
        } // for - 연산자 우선순위

        return Math.abs(nQ.poll());
    }
    
    public long solution(String expression) {
        char[] operators = { '*', '+', '-'};
        
        Queue<Long> numsQ = new LinkedList<>();                 // 숫자들
        Queue<Character> operatorsQ = new LinkedList<>();       // 연산자들 
        List<String> orders = new LinkedList<>();               // 연산자 조합 가능한 모든 경우
        
        resetInfo(expression, numsQ, operatorsQ, operators, orders);
        
        long answer = 0l;
        for (String order : orders) {
            Queue<Long> cloneNumQ = new LinkedList<>(numsQ);
            Queue<Character> cloneOperQ = new LinkedList<>(operatorsQ);
            answer = Math.max(answer, getLongToInfo(cloneNumQ, cloneOperQ, order));
        }

        return answer;
    }
}