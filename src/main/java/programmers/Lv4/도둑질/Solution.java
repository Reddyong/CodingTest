package programmers.Lv4.도둑질;

class Solution {
    private int answer, N;
    private int[] dp1, dp2;
    public int solution(int[] money) {
        init(money);
        solve(money);

        return answer;
    }

    private void solve(int[] money){
        for(int i = 2; i < N - 1; i++){
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + money[i]);
        }

        for(int i = 2; i < N; i++){
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + money[i]);
        }

        answer = Math.max(dp1[N - 2], dp2[N - 1]);
    }

    private void init(int[] money){
        N = money.length;

        dp1 = new int[N];
        dp2 = new int[N];

        dp1[0] = money[0];
        dp1[1] = Math.max(money[0], money[1]);

        dp2[1] = money[1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(new int[]{1, 2, 3, 1});

        System.out.println("solution = " + solution);
    }
}