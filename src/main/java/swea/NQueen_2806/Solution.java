package swea.NQueen_2806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static int T;
    static int count;
    static int ans;
    static int[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            count = Integer.parseInt(br.readLine());
            board = new int[count];
            ans = 0;

            solve(0);

            System.out.println("#" + t + " " + ans);
        }
    }

    private static void solve(int depth) {
        if (depth == count) {
            ans++;
            return;
        }

        for (int i = 0; i < count; i++) {
            board[depth] = i;
            if (isPossible(depth)) {
                solve(depth + 1);
            }
        }
    }

    private static boolean isPossible(int depth) {
        for (int i = 0; i < depth; i++) {
            if (board[depth] == board[i] || depth - i == Math.abs(board[depth] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
