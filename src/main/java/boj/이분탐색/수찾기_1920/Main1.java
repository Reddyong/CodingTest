package boj.이분탐색.수찾기_1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1 {
    static int N;
    static int M;
    static int min;
    static int max;
    static int mid;
    static int[] nums;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for (int cur : arr) {
            min = 0;
            max = N - 1;

            while (min <= max) {
                mid = (min + max) / 2;
                if (nums[mid] == cur) {
                    break;
                }
                if (nums[mid] > cur) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }

            if (nums[mid] == cur) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
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

        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
    }
}
