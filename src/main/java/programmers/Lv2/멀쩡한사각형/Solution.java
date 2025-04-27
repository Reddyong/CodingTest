package programmers.Lv2.멀쩡한사각형;

class Solution {
    private long answer;
    public long solution(int w, int h) {
        solve(w, h);

        return answer;
    }

    private void solve(int w, int h){
        answer = 0;
        long all = (long) w * h;

        answer = all - (w + h - gcd(w, h));
    }

    private int gcd(int a, int b){
        if(b == 0){
            return a;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution = sol.solution(8, 12);

        System.out.println("solution = " + solution);
    }
}
