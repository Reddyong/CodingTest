package programmers.bfs.단어변환;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        answer = solve(begin, target, words);

        return answer;
    }

    private int solve(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        return bfs(begin, target, words);
    }

    private int bfs(String begin, String target, String[] words) {
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(begin, 0));

        while (!queue.isEmpty()) {
            Pos poll = queue.poll();

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isChangePossible(poll.cur, words[i])) {
                    if (words[i].equals(target)) {
                        return poll.sum + 1;
                    }

                    visited[i] = true;
                    queue.add(new Pos(words[i], poll.sum + 1));
                }
            }
        }

        return 0;
    }

    private boolean isChangePossible(String cur, String compare) {
        int count = 0;

        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) == compare.charAt(i)) {
                count++;
            }
        }

        if (count == cur.length() - 1) {
            return true;
        }

        return false;
    }

    private class Pos {
        String cur;
        int sum;

        public Pos(String cur, int sum) {
            this.cur = cur;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        int solution2 = sol.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"});

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
