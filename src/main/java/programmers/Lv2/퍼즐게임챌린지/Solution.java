package programmers.Lv2.퍼즐게임챌린지;

public class Solution {
    private int min;
    private int max;
    private int mid;
    public int solution(int[] diffs, int[] times, long limit) {

        init(diffs);

        return solve(diffs, times, limit);
    }

    private int solve(int[] diffs, int[] times, long limit) {
        while (min <= max) {
            mid = (min + max) / 2;

            long temp = getCurTime(diffs, times, limit, mid);

            if (temp <= limit) {
                max = mid - 1;
                continue;
            }

            min = mid + 1;
        }

        return min;
    }

    private long getCurTime(int[] diffs, int[] times, long limit, int mid) {
        long ans = times[0];

        for (int i = 1; i < diffs.length; i++) {
            long time = 0;

            if (diffs[i] > mid) {
                time = (diffs[i] - mid) * (times[i] + times[i - 1]) + times[i];
            } else {
                time = times[i];
            }

            if (time > limit) {
                return time;
            }

            ans += time;

            if (ans > limit) {
                return ans;
            }
        }

        return ans;
    }

    private void init(int[] diffs) {
        min = 1;
        max = 0;

        for (int diff : diffs) {
            max = Math.max(max, diff);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int solution1 = sol.solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30);
        int solution2 = sol.solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59);
        int solution3 = sol.solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723);
        int solution4 = sol.solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println("solution4 = " + solution4);
    }
}
