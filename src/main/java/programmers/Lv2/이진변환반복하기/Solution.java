package programmers.Lv2.이진변환반복하기;

import java.util.Arrays;

public class Solution {
    public int[] solution(String s) {

        return solve(s);
    }

    private int[] solve(String s) {
        int[] ans = new int[2];
        int count = 0;
        int zero = 0;

        while (!s.equals("1")) {
            char[] cur = s.toCharArray();
            int len = 0;

            for (char c : cur) {
                if (c == '1') {
                    len++;
                }

                if (c == '0') {
                    zero++;
                }
            }

            s = Integer.toBinaryString(len);
            count++;
        }

        ans[0] = count;
        ans[1] = zero;

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution("110010101001");
        int[] solution2 = sol.solution("01110");
        int[] solution3 = sol.solution("1111111");

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
        System.out.println("solution3 = " + Arrays.toString(solution3));
    }
}
