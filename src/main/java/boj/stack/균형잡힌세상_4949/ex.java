package boj.stack.균형잡힌세상_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;

        while (true) {
            s = br.readLine();

            if (s.equals(".")) {
                break;
            }

            sb.append(solve(s)).append('\n');
        }

        System.out.println(sb);
    }

    private static String solve(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (isParentheses(cur)) {
                if (isOpen(cur)) {
                    stack.push(cur);
                } else {
                    if (!stack.isEmpty() && isMatch(stack.peek(), cur)) {
                        stack.pop();
                    } else {
                        return "no";
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return "yes";
        } else {
            return "no";
        }
    }

    private static boolean isMatch(Character pre, char cur) {
        return (pre == '[' && cur == ']') || (pre == '(' && cur == ')');
    }

    private static boolean isOpen(char cur) {
        return cur == '(' || cur == '[';
    }

    private static boolean isParentheses(char cur) {
        return cur == '(' || cur == ')' || cur == '[' || cur == ']';
    }
}
