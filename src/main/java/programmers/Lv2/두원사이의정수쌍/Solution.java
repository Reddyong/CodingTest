package programmers.Lv2.두원사이의정수쌍;

class Solution {
    private long answer;
    public long solution(int r1, int r2) {
        // 풀이 과정
        solve(r1, r2);

        return answer;
    }

    private void solve(int r1, int r2){
        long temp = 0;
        for(int i = 0; i <= r2; i++){
            long n2 = (long) r2 * r2;
            long n1 = (long) r1 * r1;
            long x = (long) i * i;

            long y2 = n2 - x;
            long y1 = n1 - x;

            if(Math.sqrt(y1) % 1 == 0){
                temp++;
            }

            temp += (long) Math.sqrt(y2) - (long) Math.sqrt(y1);
        }

        answer = temp * 4 - 4;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        long solution = sol.solution(2, 3);

        System.out.println("solution = " + solution);
    }
}
