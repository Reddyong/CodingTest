package programmers.Lv2.주식가격;

import java.util.*;

class Solution {
    private Stack<Integer> stack;
    private int[] answer;
    public int[] solution(int[] prices) {
        init(prices);
        solve(prices);

        return answer;
    }

    private void solve(int[] prices){
        for(int i = 0; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);
        }

        int last = stack.pop();
        answer[last] = 0;

        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = last - idx;
        }
    }

    private void init(int[] prices){
        stack = new Stack<>();
        answer = new int[prices.length];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution = sol.solution(new int[]{1, 2, 3, 2, 3});

        System.out.println("solution = " + Arrays.toString(solution));
    }
}
