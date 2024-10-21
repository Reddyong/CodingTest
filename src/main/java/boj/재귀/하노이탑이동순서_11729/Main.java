package boj.재귀.하노이탑이동순서_11729;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// NOTE : 하노의의 탑 문제 구현 방법
//  1. n-1 번 까지의 원판들을 임시 목적지에 옮김.
//  2. n 번 원판을 목적지로 옮김.
//  3. n-1 번 까지의 원판들을 목적지로 옮김.
public class Main {
    static int N;
    static int count;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = (int) (Math.pow(2, N) - 1);

        sb.append(count + "\n");
        hanoi(1, 3, N);
        System.out.println(sb);
    }

    private static void hanoi(int from, int to, int num) {
        if (num == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }

        hanoi(from, 6 - from - to, num - 1);
        sb.append(from + " " + to + "\n");
        hanoi(6 - from - to, to, num - 1);
    }
}
