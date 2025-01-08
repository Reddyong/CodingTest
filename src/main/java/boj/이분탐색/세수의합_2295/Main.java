package boj.이분탐색.세수의합_2295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] nums;
    static int[] two;
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = nums[j] - nums[i];
                int bn = binarySearch(temp);

                if (bn != -1) {
                    ans = Math.max(ans, nums[j]);
                }

            }
        }

        System.out.println(ans);
    }

    private static int binarySearch(int temp) {
        int min = 0;
        int max = two.length - 1;

        while (min < max) {
            int mid = (min + max) / 2;

            if (two[mid] > temp) {
                max = mid - 1;
            } else if (two[mid] < temp) {
                min = mid + 1;
            } else {
                return two[mid];
            }
        }

        return -1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int len = nums.length;

        while (len > 0) {
            sum += len;
            len--;
        }

        two = new int[sum];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = nums[i] + nums[j];
                two[idx] = temp;
                idx++;
            }
        }

        Arrays.sort(nums);
        Arrays.sort(two);

    }
}
