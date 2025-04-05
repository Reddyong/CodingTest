package programmers.Lv2.수식최대화;


import java.util.*;

class Solution {
    private List<Long> numbers;
    private List<String> operands;
    private List<String> uniqueOperands;
    private boolean[] visited;
    private long answer;
    private String[] op = new String[]{"*", "-", "+"};
    public long solution(String expression) {
        init(expression);
        solve();

        return answer;
    }

    private void solve(){
        visited = new boolean[uniqueOperands.size()];

        dfs(new String[uniqueOperands.size()], 0);
    }

    private void dfs(String[] temp, int depth){
        if(depth == uniqueOperands.size()){
            answer = Math.max(answer, Math.abs(calc(temp)));
            return;
        }

        for(int i = 0; i < uniqueOperands.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                temp[depth] = uniqueOperands.get(i);
                dfs(temp, depth + 1);
                visited[i] = false;
                temp[depth] = null;
            }
        }
    }

    private long calc(String[] temp){
        List<String> tempOperands = new ArrayList<>(operands);
        List<Long> tempNumbers = new ArrayList<>(numbers);

        int idx = 0;
        while(!tempOperands.isEmpty()){
            if(tempOperands.contains(temp[idx])){
                for(int i = 0; i < tempOperands.size(); i++){
                    if(tempOperands.get(i).equals(temp[idx])){
                        tempNumbers.add(i, calculation(tempNumbers.remove(i), tempNumbers.remove(i), tempOperands.remove(i)));
                        break;
                    }
                }
            } else{
                idx++;
            }
        }

        return tempNumbers.get(0);
    }

    private long calculation(long n1, long n2, String op){
        if(op.equals("*")){
            return n1 * n2;
        } else if(op.equals("-")){
            return n1 - n2;
        } else{
            return n1 + n2;
        }
    }

    private void init(String expression){
        answer = 0;
        operands = new ArrayList<>();
        uniqueOperands = new ArrayList<>();
        numbers = new ArrayList<>();

        int idx = 0;
        for(int i = 0; i < expression.length(); i++){
            char cur = expression.charAt(i);

            if(cur == '*' || cur == '-' || cur == '+'){
                operands.add(String.valueOf(cur));
                numbers.add(Long.parseLong(expression.substring(idx, i)));
                idx = i + 1;
            }
        }
        numbers.add(Long.parseLong(expression.substring(idx)));

        for(int i = 0; i < 3; i++){
            if(expression.contains(op[i])){
                uniqueOperands.add(op[i]);
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution1 = sol.solution("100-200*300-500+20");
        long solution2 = sol.solution("50*6-3*2");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
