package boj.무작위.시험감독_13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] A;
    private static int B;
    private static int C;
    private static long answer;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for(int i = 0; i < N; i++){
            if (A[i] <= B) {
                A[i] = 0;
            } else {
                A[i] -= B;
            }

            answer++;
        }

        for (int i = 0; i < N; i++) {
            if (A[i] % C != 0) {
                answer += A[i] / C + 1;
            } else {
                answer += A[i] / C;
            }
        }

        System.out.println(answer);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        answer = 0;
    }
}
