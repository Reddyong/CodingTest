package swea.SW문제해결기본1일차View_1206;

import java.util.Scanner;

public class Solution {
    static int num;
    static int[] buildings;
    public static void main(String[] args) {
        int T = 10;
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= T; i++) {
            num = sc.nextInt();
            buildings = new int[num];

            init(sc);
            solve(i);
        }
    }

    private static void solve(int test) {
        int ans = 0;

        for (int i = 2; i < num - 2; i++) {
            if (isPossibleBuilding(i)) {
                int max = Math.max(Math.max(buildings[i - 2], buildings[i - 1]), Math.max(buildings[i + 2], buildings[i + 1]));
                ans += (buildings[i] - max);
            }
        }

        System.out.println("#" + test + " " + ans);
    }

    private static boolean isPossibleBuilding(int idx) {
        for (int i = idx - 2; i <= idx + 2; i++) {
            if (i == idx) {
                continue;
            }

            if (buildings[i] >= buildings[idx]) {
                return false;
            }
        }

        return true;
    }

    private static void init(Scanner sc) {
        for (int i = 0; i < num; i++) {
            buildings[i] = sc.nextInt();
        }
    }
}
