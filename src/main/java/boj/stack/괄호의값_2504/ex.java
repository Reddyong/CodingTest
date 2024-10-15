package boj.stack.괄호의값_2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int sum = 0;
        int prod = 1;
        char pre = '(';
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if (isOpenLittle(cur)) {
                prod *= 2;
                stack.push(cur);
            } else if (isOpenBig(cur)) {
                prod *= 3;
                stack.push(cur);
            } else if (isCloseLittle(cur)) {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println("0");
                    return;
                }

                if (pre == '(') {
                    sum += prod;
                }
                prod /= 2;
                stack.pop();
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println("0");
                    return;
                }

                if (pre == '[') {
                    sum += prod;
                }
                prod /= 3;
                stack.pop();
            }

            pre = cur;
        }

        if (stack.isEmpty()) {
            System.out.println(sum);
        } else {
            System.out.println("0");
        }
    }

    public static boolean isCloseLittle(char cur) {
        return cur == ')';
    }
    public static boolean isOpenBig(char cur) {
        return cur == '[';
    }

    public static boolean isOpenLittle(char cur) {
        return cur == '(';
    }
}
