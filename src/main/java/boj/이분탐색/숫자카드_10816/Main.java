package boj.이분탐색.숫자카드_10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int min;
    static int max;
    static int mid;
    static int[] nums;
    static int[] arr;
    static int[] temp;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        for (int cur : arr) {
            // left
            int left = getLeft(cur);

            // right
            int right = getRight(cur);

            sb.append(right - left).append(' ');
        }

        System.out.println(sb);

    }

    private static int getRight(int cur) {
        min = 0;
        max = N;

        while (min < max) {
            mid = (min + max) / 2;

            if (nums[mid] <= cur) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }

    private static int getLeft(int cur) {
        min = 0;
        max = N;

        while (min < max) {
            mid = (min + max) / 2;

            if (nums[mid] < cur) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
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
        Arrays.sort(nums);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

    }
}
