package programmers.Lv3.입국심사;

import java.util.Arrays;

public class Solution {
    private long answer;
    public long solution(int n, int[] times) {
        init(times);
        solve(n, times);

        return answer;
    }

    private void solve(int n, int[] times) {
        long left = 1;
        long right = (long) times[times.length - 1] * n;

        while (left <= right) {
            long mid = (left + right) / 2;

            long people = 0;

            for (int time : times) {
                people += (mid / time);
            }

            if (people >= n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        answer = left;
    }

    private void init(int[] times) {
        Arrays.sort(times);
        answer = 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution = sol.solution(6, new int[]{7, 10});

        System.out.println("solution = " + solution);
    }
}
