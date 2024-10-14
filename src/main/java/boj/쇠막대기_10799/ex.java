package boj.쇠막대기_10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputString = br.readLine();
        int sum = 0;
        char pre = '(';
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputString.length(); i++) {
            char cur = inputString.charAt(i);

            if (isOpen(cur)) {
                stack.push(cur);
            } else {
                if (isOpen(pre)) {
                    stack.pop();
                    sum += stack.size();
                } else {
                    stack.pop();
                    sum++;
                }
            }

            pre = cur;
        }

        System.out.println(sum);
    }

    public static boolean isOpen(char cur) {
        return cur == '(';
    }
}
