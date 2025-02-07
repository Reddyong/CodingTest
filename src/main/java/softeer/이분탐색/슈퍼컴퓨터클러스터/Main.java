package softeer.이분탐색.슈퍼컴퓨터클러스터;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long B;
    private static long answer;
    private static int[] a;

    public static void main(String[] args) throws Exception {
        init();
        solve();
    }

    private static void solve(){
        long min = a[0];
        long max = a[N - 1] + (long) Math.sqrt(B);

        while(min <= max){
            long mid = (min + max) / 2;

            if(isPossible(mid)){
                min = mid + 1;
                answer = mid;
            } else{
                max = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean isPossible(long mid){
        long cost = 0;

        for(int i = 0; i < a.length; i++){
            if(a[i] >= mid){
                break;
            }

            cost += (mid - a[i]) * (mid - a[i]);

            if(cost > B){
                return false;
            }
        }

        return true;
    }

    private static void init() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        a = new int[N];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a.length; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
    }
}
