package programmers.Lv2.짝지어제거하기;

import java.util.Stack;

public class Solution {
    public int solution(String s)
    {
        return solve(s);
    }

    private int solve(String s){
        Stack<Character> stack = new Stack<>();
        char[] word = s.toCharArray();

        for(int i = 0; i < word.length; i++){
            if(!stack.isEmpty()){
                char peek = stack.peek();
                char cur = word[i];

                if(peek == cur){
                    stack.pop();
                    continue;
                }
            }

            stack.push(word[i]);
        }

        if(stack.isEmpty()){
            return 1;
        }

        return 0;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("baabaa");
        int solution2 = sol.solution("cdcd");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
