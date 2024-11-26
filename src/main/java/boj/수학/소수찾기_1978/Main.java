package boj.수학.소수찾기_1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int ans = 0;

        for (int num : nums) {
            if (isPrimeNumber(num)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    private static boolean isPrimeNumber(int num) {
        if (num == 1) {
            return false;
        }

        // NOTE : i <= Math.sqrt(num) 를 사용하면 안된다.
        //  이유는 실수계산이기 때문에 오차가 발생할 수 있다.
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
