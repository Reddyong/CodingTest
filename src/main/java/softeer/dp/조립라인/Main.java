package softeer.dp.조립라인;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] times;
    private static int[] dpA;
    private static int[] dpB;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        dpA[1] = times[1][0];
        dpB[1] = times[1][1];

        if(N == 1){
            answer = Math.min(dpA[N], dpB[N]);
            System.out.println(answer);
            return;
        }

        for(int i = 2; i <= N; i++){
            dpA[i] = Math.min(dpA[i - 1] + times[i][0], dpB[i - 1] + times[i - 1][3] + times[i][0]);
            dpB[i] = Math.min(dpB[i - 1] + times[i][1], dpA[i - 1] + times[i - 1][2] + times[i][1]);
        }

        answer = Math.min(dpA[N], dpB[N]);
        System.out.println(answer);
    }

    private static void init() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        times = new int[N + 1][4];

        for(int i = 1; i <= N - 1; i++){
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
            times[i][2] = Integer.parseInt(st.nextToken());
            times[i][3] = Integer.parseInt(st.nextToken());
        }


        st = new StringTokenizer(br.readLine());
        times[N][0] = Integer.parseInt(st.nextToken());
        times[N][1] = Integer.parseInt(st.nextToken());

        dpA = new int[N + 1];
        dpB = new int[N + 1];
    }
}
