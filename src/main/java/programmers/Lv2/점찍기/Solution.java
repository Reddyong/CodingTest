package programmers.Lv2.점찍기;

class Solution {
    private long answer;
    public long solution(int k, int d) {
        solve(k, d);

        return answer;
    }

    private void solve(int k, int d){
        answer = 0;
        long max = (long) d * d;

        for(long i = 0; i <= d; i += k){
            long cur = max - (i * i);
            long temp = (long) Math.sqrt(cur) / k + 1;

            answer += temp;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution1 = sol.solution(2, 4);
        long solution2 = sol.solution(1, 5);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}