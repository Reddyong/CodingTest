package programmers.Lv2.택배상자;

import java.util.Stack;

class Solution {
    private Stack<Integer> stack;
    private int answer;
    private int cur;
    public int solution(int[] order) {
        init();
        solve(order);

        return answer;
    }

    private void solve(int[] order){
        for(int i = 0, j = 1; i < order.length; i++){
            int num = order[i];

            while(j <= num){
                stack.push(j);
                j++;
            }

            if(!stack.isEmpty() && stack.pop() == num){
                answer++;
            } else{
                return;
            }

        }


    }

    private void init(){
        stack = new Stack<>();
        answer = 0;
        cur = 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{4, 3, 1, 2, 5});
        int solution2 = sol.solution(new int[]{5, 4, 3, 2, 1});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}