package programmers.Lv2.숫자의표현;

public class Solution {
    public int solution(int n) {

        return solve(n);
    }

    private int solve(int n){
        int ans = 0;

        for(int i = 1; i <= n; i++){
            int sum = 0;
            int cur = i;

            while(sum < n){
                sum += cur;
                cur++;
            }

            if(sum == n){
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(15);

        System.out.println("solution = " + solution);
    }
}
