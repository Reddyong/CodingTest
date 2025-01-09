package boj.이분탐색.랜선자르기_1654;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// NOTE : Parametric Search
//  -> 조건을 만족하는 최소/최댓값을 구하는 문제(최적화 문제)를 결정 문제로 변환해 이분탐색을 수행하는 방법
//  -> (최적화 문제) : N개를 만들 수 있는 랜선의 최대 길이
//  -> (결정 문제) : 랜선의 길이가 X일 때 랜선이 N개 이상인가 아닌가?
//  -> 랜선의 길이를 x축, 랜선의 개수를 y축 이라고 생각한다면 이 문제는, 감소함수의 형태를 띄게 됨.
//  -> Parametric Search 문제는 반드시 증가함수 형태 또는 감소함수 형태여야만 성립할 수 있다.
public class Main {
    private static int K;
    private static int N;
    private static int[] lan;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        long min = 1;
        long max = Integer.MAX_VALUE;

        while (min < max) {
            long mid = (min + max + 1) / 2; // NOTE : min, max 가 1차이 날때 무한루프 빠지지 않도록 +1 해줌
            long num = getLanNums(mid);

            if (num < N) {
                max = mid - 1;
            } else {
                min = mid;
            }
        }

        System.out.println(min);
    }

    private static long getLanNums(long mid) {
        long sum = 0;

        for (int l : lan) {
            sum += (l / mid);
        }

        return sum;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan = new int[K];

        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
    }
}
