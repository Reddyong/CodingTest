package programmers.Lv2.예상대진표;

public class Solution {
    public int solution(int n, int a, int b)
    {

        return solve(n, a, b);
    }

    private int solve(int n, int a, int b){
        a--;
        b--;

        int ans = 1;

        while(a / 2 != b / 2){
            a /= 2;
            b /= 2;
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution = sol.solution(8, 4, 7);

        System.out.println("solution = " + solution);
    }
}
