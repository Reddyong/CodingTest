package programmers.dfs.타겟넘버;

import java.util.Stack;

public class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        answer = dfs(numbers, target);

        return answer;
    }

    private int dfs(int[] numbers, int target) {
        Stack<Pos> stack = new Stack<>();
        stack.push(new Pos(0, 0));

        int count = 0;

        while (!stack.isEmpty()) {
            Pos pop = stack.pop();

            if (pop.idx == numbers.length) {
                if (pop.sum == target) {
                    count++;
                }

                continue;
            }

            stack.push(new Pos(pop.idx + 1, pop.sum + numbers[pop.idx]));
            stack.push(new Pos(pop.idx + 1, pop.sum - numbers[pop.idx]));
        }

        return count;
    }

    private class Pos {
        int idx;
        int sum;

        public Pos(int idx, int sum) {
            this.idx = idx;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution(new int[]{1, 1, 1, 1, 1}, 3);
        int solution2 = sol.solution(new int[]{4, 1, 2, 1}, 4);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
