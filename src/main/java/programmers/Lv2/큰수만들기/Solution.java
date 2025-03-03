package programmers.Lv2.큰수만들기;

import java.util.*;

class Solution {
    private String answer;
    private String[] split;
    private Stack<Integer> stack;
    public String solution(String number, int k) {
        solve(number, k);

        return answer;
    }

    private void solve(String number, int k){
        split = number.split("");
        stack = new Stack<>();
        int count = 0;

        for(int i = 0; i < number.length(); i++){
            int cur = Integer.parseInt(split[i]);

            while(!stack.isEmpty() && stack.peek() < cur && count < k){
                stack.pop();
                count++;
            }

            stack.push(cur);

        }

        while(count < k){
            stack.pop();
            count++;
        }

        StringBuilder sb = new StringBuilder();
        for(int num : stack){
            sb.append(num);
        }

        answer = sb.toString();

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution1 = sol.solution("1924", 2);
        String solution2 = sol.solution("1231234", 3);
        String solution3 = sol.solution("4177252841", 4);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
