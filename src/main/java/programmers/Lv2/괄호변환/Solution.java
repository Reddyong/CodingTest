package programmers.Lv2.괄호변환;

import java.util.*;

class Solution {
    private String answer;
    public String solution(String p) {
        solve(p);

        return answer;
    }

    private void solve(String p){
        answer = gwalho(p);
    }

    private String gwalho(String cur){
        if(cur.isEmpty() || cur.equals("")){
            return "";
        }

        int idx = 0;
        int open = 0;
        int close = 0;

        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) == '('){
                open++;
            } else{
                close++;
            }

            if(open == close){
                idx = i + 1;
                break;
            }
        }

        String u = cur.substring(0, idx);
        String v = cur.substring(idx);

        if(isCorrectGwalho(u)){
            return u + gwalho(v);
        } else{
            String tempU = u.substring(1, u.length() - 1);
            tempU = changeDirGwalho(tempU);
            return "(" + gwalho(v) + ")" + tempU;
        }
    }

    private String changeDirGwalho(String cur){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < cur.length(); i++){
            if(cur.charAt(i) == '('){
                sb.append(")");
            } else{
                sb.append("(");
            }
        }

        return sb.toString();
    }

    private boolean isCorrectGwalho(String cur){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < cur.length(); i++){
            if(stack.isEmpty()){
                stack.push(cur.charAt(i));
                continue;
            }

            char peek = stack.peek();

            if(isMade(peek, cur.charAt(i))){
                stack.pop();
                continue;
            }

            stack.push(cur.charAt(i));
        }

        if(stack.isEmpty()){
            return true;
        }

        return false;
    }

    private boolean isMade(char pre, char cur){
        if(pre == '(' && cur == ')'){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution1 = sol.solution("(()())()");
        String solution2 = sol.solution(")(");
        String solution3 = sol.solution("()))((()");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
