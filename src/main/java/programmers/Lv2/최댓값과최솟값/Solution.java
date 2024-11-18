package programmers.Lv2.최댓값과최솟값;

import java.util.Arrays;

public class Solution {
    static int[] nums;
    public String solution(String s) {
        init(s);

        return solve();
    }

    private String solve() {
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append(" ").append(nums[nums.length - 1]);

        return sb.toString();
    }

    private void init(String s) {
        String[] split = s.split(" ");
        nums = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String solution1 = sol.solution("1 2 3 4");
        String solution2 = sol.solution("-1 -2 -3 -4");
        String solution3 = sol.solution("-1 -1");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
