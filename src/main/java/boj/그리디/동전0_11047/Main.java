package boj.그리디.동전0_11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// NOTE : 이 문제는 동전의 액수가 배수 관계여서 내림차순으로 보며 그리디 돌았을때 성립하는 것이다.
//  다음과 같이 1원, 9원, 10원의 동전이 있고 18원을 구하는 동전의 최소 갯수를 구할 때는 다른 방법을 생각해보아야 한다.
//  비슷한 문제를 풀어봤다는 이유로, 같은 풀이로 한정짓는것은 굉장히 위험할 수 있다.
public class Main {
    static int N;
    static int K;
    static int ans;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int i = N - 1; i >= 0; i--) {
            int count = K / coins[i];
            ans += count;
            K %= coins[i];
        }

        System.out.println(ans);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        ans = 0;
        coins = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }
    }
}
