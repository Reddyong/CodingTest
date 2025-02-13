package programmers.Lv2.뒤에있는큰수찾기;

import java.util.*;

class Solution {
    private Stack<Integer> stack;
    private int[] answer;
    public int[] solution(int[] numbers) {
        init(numbers);
        solve(numbers);

        return answer;
    }

    private void solve(int[] numbers){
        for(int i = 0; i < numbers.length; i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            int cur = numbers[i];

            while(!stack.isEmpty() && numbers[stack.peek()] < cur){
                int idx = stack.pop();
                answer[idx] = cur;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int idx = stack.pop();
            answer[idx] = -1;
        }
    }

    private void init(int[] numbers){
        stack = new Stack<>();
        answer = new int[numbers.length];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new int[]{2, 3, 3, 5});
        int[] solution2 = sol.solution(new int[]{9, 1, 5, 3, 6, 2});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));

    }
}
