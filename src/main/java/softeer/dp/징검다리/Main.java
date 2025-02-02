package softeer.dp.징검다리;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int max;
    private static int[] nums;
    private static int[] dp;

    public static void main(String[] args) throws Exception{
        init();
        solve();
    }

    private static void solve(){
        // dp[i] = i 번째 돌을 무조건 밟는다는 가정하에 밟은 돌의 최대 갯수
        // 1 2
        for(int i = 1; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for(int d : dp){
            max = Math.max(max, d);
        }

        System.out.println(max);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        dp[0] = 1;
    }

    private static class Pos{
        int height;
        int max;

        public Pos(int height, int max){
            this.height = height;
            this.max = max;
        }
    }
}
