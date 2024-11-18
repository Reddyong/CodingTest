package programmers.Lv2.올바른괄호;

import java.util.Stack;

public class Solution {
    private Stack<Character> stack;
    private char[] gwalhos;
    public boolean solution(String s) {
        init(s);

        return solve();
    }

    private boolean solve() {
        for (int i = 0; i < gwalhos.length; i++) {
            char cur = gwalhos[i];

            if (!stack.isEmpty()) {
                Character peek = stack.peek();
                if (!isOpen(peek)) {
                    return false;
                }

                if (isMatched(peek, cur)) {
                    stack.pop();
                    continue;
                }
            }

            stack.push(cur);
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }

    private boolean isMatched(char pre, char cur) {
        if (pre == '(' && cur == ')') {
            return true;
        }

        return false;
    }

    private boolean isOpen(char peek) {
        if (peek == '(') {
            return true;
        }

        return false;
    }

    private void init(String s) {
        gwalhos = s.toCharArray();  // NOTE : s.split() 으로 String[] 배열로 진행하면 시간초과 발생
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean solution1 = sol.solution("()()");
        boolean solution2 = sol.solution("(())()");
        boolean solution3 = sol.solution(")()(");
        boolean solution4 = sol.solution("(()(");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
    }
}
