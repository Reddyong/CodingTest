package softeer.재귀.바이러스;

import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int P;
    static int N;
    static long ans;

    public static void main(String[] args) throws IOException{
        init();
        solve();
    }

    private static void solve(){
        ans = recur(K, 0);

        System.out.println(ans);
    }

    private static long recur(long cur, int depth){
        if(depth == N){
            return cur % 1000000007;
        }

        cur = ((cur % 1000000007) * (P % 1000000007)) % 1000000007;

        return recur(cur, depth + 1) % 1000000007;
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        ans = 0;
    }
}

