package programmers.Lv2.괄호회전하기;

import java.util.Stack;

public class Solution {
    private int answer;
    private char[] gwalho;
    public int solution(String s) {
        init(s);
        solve();

        return answer;
    }

    private void solve(){
        int len = gwalho.length / 2;

        for(int i = 0; i < len; i++){
            Stack<Character> stack = new Stack<>();
            for(int j = i; j < i + len; j++){
                char cur = gwalho[j];

                if(!stack.isEmpty() && isMatch(cur, stack.peek())){
                    stack.pop();
                    continue;
                }

                stack.push(cur);
            }

            if(stack.isEmpty()){
                answer++;
            }
        }
    }

    private boolean isMatch(char cur, char prev){
        if(cur == '}' && prev == '{'){
            return true;
        }

        if(cur == ')' && prev == '('){
            return true;
        }

        if(cur == ']' && prev == '['){
            return true;
        }

        return false;
    }

    private void init(String s){
        answer = 0;
        String newS = s + s;

        gwalho = newS.toCharArray();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("[](){}");
        int solution2 = sol.solution("}]()[{");
        int solution3 = sol.solution("[)(]");
        int solution4 = sol.solution("}}}");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
    }
}
