package programmers.Lv2.점프와순간이동;

public class Solution {
    public int solution(int n) {

        return solve(n);
    }

    private int solve(int n){
        int ans = 0;

        while(n != 0){
            if(n % 2 == 0){
                n /= 2;
                continue;
            }

            n--;
            ans++;
        }

        return ans;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(5);
        int solution2 = sol.solution(6);
        int solution3 = sol.solution(5000);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }
}
