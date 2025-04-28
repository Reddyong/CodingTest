package programmers.Lv0.심폐소생술;

import java.util.Arrays;

class Solution {
    public int[] solution(String[] cpr) {
        int[] answer = {0, 0, 0, 0, 0};
        String[] basic_order = {"check", "call", "pressure", "respiration", "repeat"};

        for (int i = 0; i < cpr.length; i++) {
            // 각 단계의 cpr이 몇번째 해당하는지 판단
            for (int j = 0; j < basic_order.length; j++) {
                if (cpr[i].equals(basic_order[j])) {
                    // 결괏 값은 인덱스에 비해 1 크므로 j + 1
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] solution1 = sol.solution(new String[]{"call", "respiration", "repeat", "check", "pressure"});
        int[] solution2 = sol.solution(new String[]{"respiration", "repeat", "check", "pressure", "call"});

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }
}
