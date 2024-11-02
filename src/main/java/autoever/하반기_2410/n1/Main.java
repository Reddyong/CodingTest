package autoever.하반기_2410.n1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int time;
    static Set<String> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        getTime();

        System.out.println(time);
    }

    private static void getTime() {
        Queue<Car> queue = new LinkedList<>();
        queue.add(new Car(0, 0, 1));
        set.add("001");

        while (!queue.isEmpty()) {
            Car poll = queue.poll();
            int curFast = poll.fas;
            int curLocation = poll.loc;

            if (curLocation == N) {
                for (int i = 0; i <= K; i++) {
                    if (curFast - i == 0) {
                        time = poll.sec;
                        return;
                    }
                }
            }

            for (int i = K * (-1); i <= K; i++) {
                int newFast = curFast + i;
                int newLocation = curLocation + newFast;

                if (newLocation < curLocation || newLocation > N) {
                    continue;
                }

                String s = String.valueOf(poll.sec + 1) + String.valueOf(newFast) + String.valueOf(newLocation);

                if (set.contains(s)) {
                    continue;
                }

                queue.add(new Car(poll.sec + 1, newFast, newLocation));
                set.add(s);
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        time = 0;
    }

    private static class Car {
        int sec;
        int fas;
        int loc;

        public Car(int sec, int fas, int loc) {
            this.sec = sec;
            this.fas = fas;
            this.loc = loc;
        }
    }
}
