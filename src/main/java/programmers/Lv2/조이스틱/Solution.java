package programmers.Lv2.조이스틱;

class Solution {
    private int answer, move, length;
    public int solution(String name) {
        // 초기화
        init(name);
        // 풀이 과정
        solve(name);

        return answer;
    }

    private void solve(String name){
        for(int i = 0; i < length; i++){
            char cur = name.charAt(i);
            // 조이스틱 위, 아래 이동
            answer += Math.min(cur - 'A', 'Z' - cur + 1);

            int idx = i + 1;
            while(idx < length && name.charAt(idx) == 'A'){
                idx++;
            }

            move = Math.min(move, (i * 2) + length - idx);
            move = Math.min(move, (length - idx) * 2 + i);
        }

        answer += move;
    }

    private void init(String name){
        answer = 0;
        length = name.length();
        move = length - 1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int solution1 = sol.solution("JEROEN");
        int solution2 = sol.solution("JAN");

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}
