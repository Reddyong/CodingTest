package programmers.Lv2.N개의최소공배수;

public class Solution {
    private int[] dp;
    public int solution(int[] arr) {

        init(arr);

        return solve(arr);
    }

    private int solve(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int max = getMax(arr[i], dp[i - 1]);
            dp[i] = arr[i] * dp[i - 1] / max;
        }

        return dp[arr.length - 1];
    }

    private int getMax(int n1, int n2){
        int temp = 0;
        int min = Math.min(n1, n2);
        int max = Math.max(n1, n2);

        for(int i = 1; i <= min; i++){
            if(min % i == 0 && max % i == 0){
                temp = i;
            }
        }

        return temp;
    }

    private void init(int[] arr){
        dp = new int[arr.length];
        dp[0] = arr[0];
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{2, 6, 8, 14});
        int solution2 = sol.solution(new int[]{1, 2, 3});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
